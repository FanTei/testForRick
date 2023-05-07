package ric.masters.driverservice.service;

import ric.masters.driverservice.entity.Account;

public interface AccountService {
    Account putCountInRed(long driverId, double countReAccount);
    Account putCountInGreen(long driverId, double countGreeAccount);
    Account putCountInBlue(long driverId, double countBluAccount);
    Account takeCountInRed(long driverId, double countReAccount);
    Account takeCountInGreen(long driverId, double countGreeAccount);
    Account takeCountInBlue(long driverId, double countBlue);
}
