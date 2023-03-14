package com.erphotel.Login.service;

import com.erphotel.Login.domain.LoginDomain;

import java.util.List;

public interface LoginService {
    public List<LoginDomain> listPersonas();

    public void salvar(LoginDomain persona);

    public void borrar (LoginDomain persona);

    public LoginDomain localizarPersona (LoginDomain persona);
}
