package com.androiddesdecero.daggerfinal.ui.login;

import com.androiddesdecero.daggerfinal.model.User;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

/*
Modelo Vista Presentador
Siempre debes programar con un tipo de Patrón
Para que tu app sea expandible facilmente, mantenida facilmente tiene que estar programada por capas
y eso nos lo ofrece MVP
Su carateristica principal es que la Vista no tiene ningun tipo de logica de negocio, es decir
que solo muestra cosas y detecta acciones del usuario, ejemplo pulsar un botón. Pero nada de logica
El Presenter es el intermediario entre la vista y Modelo.
Modelo -> El proveedor de datos, si es una base de datos local, web service, etc y la logica de negocio.

Vamos a hacer una aplicación real usando dagger, en el que nos va a permitir inyectar los objetos que necesitamos
en nuestro modelo MVP, nos va a permitir inyectar el Presentador en la Vista
Vamos a inyectar nuestro objeto retrofit para hacer peticiones web.
Vamos a inyectar un objeto Usuario que podremos acceder a el en todas las activitis y bueno, esto nos permitira
pues hacer peticiones web con nuestro user y demás. Por ello Dagger 2 es fundamental hoy en día en
cualquier aplicación grande, recordamos que nos ofrece:
La ventaja esta en que nos permite escrbir codigo más leible, expandible y mantenible
y además es facil de testear.

Y por supuesto cumplir el quinto principio de SOLID es decir el principio de inversion de la depdencia.
Es decir que los objetos o instancias deben depender de abstracciones y no de implementaciones.
 */

public class LoginPresenter implements Login.Presenter {

    private Login.View view;

    private User user;

    public LoginPresenter(User user){
        this.user = user;
    }

    @Override
    public void setView(Login.View view) {
        this.view = view;
    }

    @Override
    public void validaUser(String userName, String pass) {
        if(view != null){
            if (userName.equals("alberto")&& pass.equals("1234")){
                user.setUsername("Alberto Palomar");
                user.setEdad("30");
                view.usarioValido();
            }else{
                view.error();
            }
        }
    }
}
