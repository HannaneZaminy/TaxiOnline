package ir.maktab.web;

import ir.maktab.servic.AccountService;
import ir.maktab.servic.mapper.AccountMapper;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;


    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
}
