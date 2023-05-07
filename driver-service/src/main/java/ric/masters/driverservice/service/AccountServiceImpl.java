package ric.masters.driverservice.service;

import org.springframework.stereotype.Service;
import ric.masters.driverservice.entity.Account;
import ric.masters.driverservice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account putCountInRed(long driverId, double countRed) {
        Account account = accountRepository.getAccountByDriverId(driverId).orElseThrow();
        account.setCountInRed(account.getCountInRed() + countRed);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account putCountInGreen(long driverId, double countGreen) {
        Account account = accountRepository.getAccountByDriverId(driverId).orElseThrow();
        account.setCountInRed(account.getCountInRed() + countGreen / 2.5);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account putCountInBlue(long driverId, double countBlue) {
        Account account = accountRepository.getAccountByDriverId(driverId).orElseThrow();
        double green = countBlue / 0.6;
        double red = green / 2.5;
        account.setCountInRed(account.getCountInRed() + red);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account takeCountInRed(long driverId, double countRed) {
        Account account = accountRepository.getAccountByDriverId(driverId).orElseThrow();
        account.setCountInRed(account.getCountInRed() - countRed);
        if (account.getCountInRed() < 0) throw new RuntimeException();
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account takeCountInGreen(long driverId, double countGreen) {
        Account account = accountRepository.getAccountByDriverId(driverId).orElseThrow();
        account.setCountInRed(account.getCountInRed() - countGreen / 2.5);
        if (account.getCountInRed() < 0) throw new RuntimeException();
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account takeCountInBlue(long driverId, double countBlue) {
        Account account = accountRepository.getAccountByDriverId(driverId).orElseThrow();
        double green = countBlue / 0.6;
        double red = green / 2.5;
        account.setCountInRed(account.getCountInRed() - red);
        if (account.getCountInRed() < 0) throw new RuntimeException();
        accountRepository.save(account);
        return account;
    }
}
