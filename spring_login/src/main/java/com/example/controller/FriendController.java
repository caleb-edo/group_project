package com.example.controller;

import com.example.model.Request;
import com.example.model.User;
import com.example.repo.RequestRepository;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private UserRepository urepo;

    @Autowired
    private RequestRepository rrepo;

    //Controller method to view list of friends and requests
    @GetMapping("/friends")
    /*public String friends(Model model, Principal principal) {
        User user = urepo.findByName(principal.getName());
        */
    public String friends(@RequestParam(name = "msg", required = false) String msg, Model model, OAuth2AuthenticationToken token) {
        User user = urepo.findByName((String) token.getPrincipal().getAttributes().get("given_name"));
        String message = msg != null ? msg : "";
        List<Request> requests = user.getRequests();
        model.addAttribute("user", user);
        model.addAttribute("friends", user.getFriends());
        model.addAttribute("requests", requests);
        model.addAttribute("msg", message);
        return "friends/friendlist";
    }

    //Controller method to remove friends
    @GetMapping("/remove")
    public String remove(@RequestParam(name = "userid") int userid,
                         @RequestParam(name = "friendid") int friendid) {

        if (urepo.findById(userid).isPresent()) {

            User user = urepo.findById(userid).get();
            for (User u: user.getFriends()) {
                if (u.getId() == friendid) {
                    user.getFriends().remove(u);
                    user = urepo.save(user);
                    u.getFriends().remove(user);
                    u = urepo.save(u);
                    break;
                }
            }
        }
        return "redirect:/friends";
    }

    //Controller method to add friends
    @RequestMapping("/newFriend")
    public String newFriend(@RequestParam int userid, Model model) {
        model.addAttribute("userid", userid);
        return "friends/addfriendform";
    }

    //Controller method that maps to form action, to add friends
    //*** Add Validation: ensure user cannot send request to themselves, cannot send duplicate requests
    @PostMapping("/addFriend")
    public String addFriend(@RequestParam(name = "name") String name,
                            @RequestParam(name = "userid") int userid, RedirectAttributes redirectAttributes) {

        if (urepo.findByName(name) != null) {
            User receiver = urepo.findByName(name);
            User sender = urepo.findById(userid).orElse(null);


            /* Validation to ensure user cannot add self */
            if (receiver.getName().equals(sender.getName())) {
                String msg = "Cannot add yourself!";
                redirectAttributes.addAttribute("msg", msg);
                return "redirect:/friends";
            }

            /* Validation to ensure user(sender) has not sent this request before */
            for (Request r: rrepo.findAll()) {
                if (r.getSender().getId()==sender.getId() && r.getReceiver().getId()== receiver.getId()) {
                    String msg = "You have already sent a request to this user!";
                    redirectAttributes.addAttribute("msg", msg);
                    return "redirect:/friends";
                }
            }

            /* Validation to ensure user(sender) does not currently have a request from user(receiver) */
            for (Request r: sender.getRequests()) {
                if (r.getSender().getId() == receiver.getId()) {
                    String msg = "You have already received a request from this user!";
                    redirectAttributes.addAttribute("msg", msg);
                    return "redirect:/friends";
                }
            }

            /* Validation to ensure user is not sending a request to a friend */
            for (User u: sender.getFriends()) {
                if (u.getId()== receiver.getId()) {
                    String msg = "You are already friends with this user!";
                    redirectAttributes.addAttribute("msg", msg);
                    return "redirect:/friends";
                }
            }

            /* Makes a new friend request object */
            Request request = new Request();
            request.setSender(sender);
            request.setReceiver(receiver);
            request.setR_status("Pending");
            request = rrepo.save(request);

            /* Add the request to list of friends requests in user (receiver) object */
            receiver.getRequests().add(request);
            receiver = urepo.save(receiver);
        } else {
            /* Error page if user (receiver) does not exist */
            String msg = "User not found!";
            redirectAttributes.addAttribute("msg", msg);
            return "redirect:/friends";
        }
        return "redirect:/friends";
    }

    //Controller method to accept friend requests
    @GetMapping("/accept")
    public String accept(@RequestParam int userid, @RequestParam int requestid) {


        /*Finds user (receiver) from repo, add the other user (sender) to friends list
         * Removes the friend request from user's requests
         * Saves repo
         * */
        User user = urepo.findById(userid).orElse(null);
        Request request = rrepo.findById(requestid).orElse(null);
        user.getFriends().add(request.getSender());
        user.getRequests().remove(request);
        user = urepo.save(user);

        /*Finds user (sender) from repo, add the other user (receiver) to friends list
         * Saves repo
         * */
        User sender = urepo.findById(request.getSender().getId()).get();
        sender.getFriends().add(user);
        sender = urepo.save(sender);

        /* Changes the status of the request and saves repo */
        request.setR_status("Accepted");
        request = rrepo.save(request);

        return "redirect:/friends";
    }

    //Controller method to decline friend requests
    @GetMapping("/decline")
    public String decline(@RequestParam int userid, @RequestParam int requestid) {

        /*Finds user (receiver) from repo
         * Removes the friend request from user's requests
         * */
        User user = urepo.findById(userid).orElse(null);
        Request request = rrepo.findById(requestid).orElse(null);
        user.getRequests().remove(request);
        user = urepo.save(user);

        /* Changes the status of the request and saves repo */
        request.setR_status("Declined");
        request = rrepo.save(request);

        return "redirect:/friends";
    }
}
