package com;

import java.util.List;

public class UsuarioService {
    private UsuarioDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public UsuarioService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new UsuarioDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Usuario usuario){
        try{
            simpleEntityManager.beginTransaction();
            usuario.validate();
            dao.save(usuario);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Usuario> findAll(){
        return dao.findAll();
    }
}
