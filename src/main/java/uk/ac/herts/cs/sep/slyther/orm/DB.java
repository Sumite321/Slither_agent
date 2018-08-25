/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.herts.cs.sep.slyther.orm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.UIManager;
import static net.gegy1000.slyther.client.ClientMain.loadNatives;
import net.gegy1000.slyther.client.SlytherClient;
import net.gegy1000.slyther.game.entity.Snake;
import org.reflections.Reflections;
import uk.ac.herts.cs.sep.slyther.SlytherMain;
import uk.ac.herts.cs.sep.slyther.util.Sha256;

/**
 *
 * @author comqdhb
 *
 * Contains all players information includes: snakes food scores
 *
 *
 *
 *
 */
public class DB {

    private SlytherClient client;
    private static final String PERSISTENCE_UNIT_NAME = "uk.ac.herts.cs.sep.SlytherPU";
    private EntityManagerFactory factory;
    private EntityManager em;
    private Sha256 encode;
    private Date dateStart;
    private DateFormat dateFormat;
    private ArrayList<GameSnake> allSnakes;
    private ArrayList<PlayerSnake> playerSnake;

    public DB(SlytherClient client, Date startTime) {
        this.client = client;
        this.dateStart = startTime;

    }
    
    public DB(){}

    public void connectToDB() {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    public void addPlayerToDB() {

        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateNow = new Date();
        em.getTransaction().begin();
        PlayerSnake player = new PlayerSnake();

        player.setId(client.player.id);
        player.setController_id(client.player.id);

        player.setName(encode.hashString("Patron"));
        player.setSnakeLength(client.player.getLength());

        // needs a starting time in a string
        // needs an ending time in a string
        // put the time alive in string
        int secondsAlive = (int) (dateNow.getTime() - dateStart.getTime()); // now contains the secondsAlive
        int seconds = secondsAlive / 1000; 
        player.setDate(dateFormat.format(dateStart));
        player.setAlivefor(seconds);

        em.persist(player);
        em.getTransaction().commit();
        
    }

    public void addGameSnakeToDB() {

        for (Snake s : client.getSnakes()) {

            em.getTransaction().begin();
            GameSnake g = new GameSnake();
            g.setName(encode.hashString(s.name));
            g.setSnakeLength(s.getLength());
            g.setId(s.id);
            em.persist(g);
            em.getTransaction().commit();
            
        }
    }

    public void readAllGameSnakes() {
        
        allSnakes = new ArrayList<>();
        Query q = em.createQuery("SELECT u from GameSnake u");
        List<GameSnake> snakeList = q.getResultList();
        for (GameSnake snake : snakeList) {
            System.out.println(snake.getSnakeLength());
            allSnakes.add(snake);
        }
        System.out.println("Size: " + snakeList.size());
        System.out.println("Information extracted from database");
    }
    
    public void readPlayerSnakes() {

        playerSnake = new ArrayList<>();
        Query p = em.createQuery("SELECT p from PlayerSnake p");
        List<PlayerSnake> snakeList = p.getResultList();
        for (PlayerSnake snake : snakeList) {
            System.out.println(snake.getDate());
            playerSnake.add(snake);
        }
        System.out.println("Size: " + snakeList.size()); 
        System.out.println("Information extracted from database");
    }

    public ArrayList<GameSnake> getAllSnakes() {
        return allSnakes;
    }

    public ArrayList<PlayerSnake> getPlayerSnake() {
        return playerSnake;
    }
    
    public void close(){em.close();}
    
    
    
}
