package oit.is.z0209.kaizi.janken1.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0209.kaizi.janken1.model.Entry;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  @GetMapping("/lec02")
  public String lec02(Principal prin, ModelMap model) {

    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    return "/lec02.html";
  }

  @PostMapping("/lec02")
  public String lec02(@RequestParam String name, ModelMap model) {
    model.addAttribute("name", name);
    return "lec02.html";
  }

  @GetMapping("/lec02janken")
  public String sample23(@RequestParam String hand, ModelMap model) {
    String computerHand = "Gu";
    String jankenResult = "";

    if (hand.equals("Gu") == computerHand.equals("Gu")) {
      jankenResult = "Draw!";
    } else if (hand.equals("Choki") == computerHand.equals("Gu")) {
      jankenResult = "You Lose!";
    } else if (hand.equals("Pa") == computerHand.equals("Gu")) {
      jankenResult = "You Win!";
    }

    model.addAttribute("sentence1", "あなたの手 ");
    model.addAttribute("sentence2", "相手の手 ");
    model.addAttribute("sentence3", "結果 ");
    model.addAttribute("hand", hand);
    model.addAttribute("computerHand", computerHand);
    model.addAttribute("jankenResult", jankenResult);

    return "lec02.html";

  }
}
