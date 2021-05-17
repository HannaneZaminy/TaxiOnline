package ir.maktab.servic;
import java.util.List;

import ir.maktab.data.repository.AccountRepository;
import ir.maktab.servic.dto.*;
import ir.maktab.servic.mapper.AccountMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
private final AccountRepository accountRepository;
private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public void create(AccountDto accountDto) {

    }

    @Override
    public void update(AccountDto accountDto) throws Exception {

    }

    @Override
    public AccountDto get(Long id) throws Exception {
        return null;
    }

    @Override
    public List getAl() {
        return null;
    }
}
