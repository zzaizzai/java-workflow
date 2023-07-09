package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Account;
import com.example.demo.model.MyInformation;
import com.example.demo.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	HttpSession session;

	@Autowired
	MyInformation myInformation;
	
	@GetMapping("")
	public String index() {
		return "account/index";
	}

	@GetMapping("/register")
	public String register() {
		return "account/register";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		
		return "account/mypage";
	}

	@GetMapping("/login")
	public String login() {
		if (myInformation.isLoggedIn()) {
			
			return "redirect:/account/mypage";
		}
		
		return "account/login";
	}

	@PostMapping("/logout")
	public String logout() {
		
		myInformation.logout();

		return "account/login";
	}

	@PostMapping("/login")
	public String loginDone(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {

		boolean isSuccess = false;
		Account account = accountRepository.findByLoginId(id);

		String msg = "";
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		if (account == null) {
			msg = "no account";
			model.addAttribute("msg", msg);
			return "account/login";
		}

		if (account.getLoginPw().equals(pw)) {
			isSuccess = true;
		}

		if (isSuccess) {
			msg = "success!";
			myInformation.login(account.getLoginId(), account.getName(), account.getIsAdmin());
		}


		model.addAttribute("msg", msg);

		return "redirect:/account/mypage";
	}

	@PostMapping("/register")
	public String registerDone(@RequestParam("name") String name, @RequestParam("id") String id,
			@RequestParam("pw") String pw, Model model) {

		String msg = "done";
		boolean succeed = true;

		if (name.length() > 20) {
			msg = "too long";
			succeed = false;
		}

		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);

		Account account = accountRepository.findByLoginId(id);
		if (account != null) {
			msg = "already exist account";
			succeed = false;
		}

		model.addAttribute("msg", msg);

		if (succeed) {
			Account accountNew = new Account();
			accountNew.setLoginId(id);
			accountNew.setLoginPw(pw);
			accountNew.setName(name);

			accountRepository.save(accountNew);
		}

		return "account/register";
	}

}
