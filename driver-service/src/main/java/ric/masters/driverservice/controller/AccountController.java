package ric.masters.driverservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ric.masters.driverservice.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/put/{driverId}")
    public ResponseEntity<?> put(@PathVariable long driverId,
                                 @RequestParam(required = true, name = "countType") String countType,
                                 @RequestParam(required = true, name = "count") double count) {
        switch (countType) {
            case "red" -> {
                try {
                    return new ResponseEntity<>(accountService.putCountInRed(driverId, count), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            case "green" -> {
                try {
                    return new ResponseEntity<>(accountService.putCountInGreen(driverId, count), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            case "blue" -> {
                try {
                    return new ResponseEntity<>(accountService.putCountInBlue(driverId, count), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            default -> {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

    @PutMapping("/account/take/{driverId}")
    public ResponseEntity<?> take(@PathVariable long driverId,
                                  @RequestParam(required = true, name = "countType") String countType,
                                  @RequestParam(required = true, name = "count") double count) {
        switch (countType) {
            case "red" -> {
                try {
                    return new ResponseEntity<>(accountService.takeCountInRed(driverId, count), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            case "green" -> {
                try {
                    return new ResponseEntity<>(accountService.takeCountInGreen(driverId, count), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            case "blue" -> {
                try {
                    return new ResponseEntity<>(accountService.takeCountInBlue(driverId, count), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            default -> {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}
