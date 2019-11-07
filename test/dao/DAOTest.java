/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrador;
import modelo.Tutor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CC07562182922
 */
public class DAOTest {
    
    public DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        Administrador adm = new Administrador("ADMIN", "Admin", "admin");
        DAO<Administrador> dao = new DAO(Administrador.class);
        dao.inserir(adm);
    }
    
//    @Test
//    public void testListar(){
//        List<Administrador> lista = new DAO(Administrador.class).listarTodos();
//        for(Administrador adm : lista){
//            System.out.println(adm);
//        }
//    }
//    @Test
//    public void testSomeMethod(){
//        Tutor tutor = new Tutor ("Yuri", "384.548.898.09", "Emilio Luciano 1113", "998252958");
//        DAO<Tutor> dao = new DAO (Tutor.class);
//        dao.inserir(tutor);
//    }
    
}
