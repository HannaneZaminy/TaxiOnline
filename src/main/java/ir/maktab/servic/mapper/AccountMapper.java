package ir.maktab.servic.mapper;

import ir.maktab.data.domain.Account;
import ir.maktab.servic.dto.AccountDto;

public interface AccountMapper {
   Account toAccount(AccountDto accountDto);

    AccountDto toAccountDto(Account account);
}
