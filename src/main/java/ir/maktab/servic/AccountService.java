package ir.maktab.servic;
import ir.maktab.servic.dto.*;

import java.util.List;

public interface AccountService {
    void create(AccountDto accountDto);
    void update(AccountDto accountDto) throws Exception;
    AccountDto get(Long id) throws Exception;
    List getAl();
}
