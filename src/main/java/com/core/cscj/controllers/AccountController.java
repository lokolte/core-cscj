package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.services.AccountService;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.CursoService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(value="/alumnos/import")
    public void loadData(@RequestParam("file") MultipartFile file) throws IOException, InvalidFormatException {
        accountService.loadData(file);
    }
}