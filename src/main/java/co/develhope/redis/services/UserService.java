package co.develhope.redis.services;

import co.develhope.redis.entities.User;
import co.develhope.redis.entities.UserJPA;
import co.develhope.redis.entities.UserRedis;
import co.develhope.redis.repositories.UserRepositoryJpa;
import co.develhope.redis.repositories.UserRepositoryRedis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private UserRepositoryRedis userRepositoryRedis;


    public UserRedis convertData(UserJPA user){
        UserRedis userRedis = new UserRedis();
        BeanUtils.copyProperties(user, userRedis);
        return userRedis;
    }

    public UserJPA convertData(UserRedis user){
        UserJPA userJpa = new UserJPA();
        BeanUtils.copyProperties(user, userJpa);
        return userJpa;
    }


    public UserJPA create(UserJPA user) {
        if (user==null)return null;
        user.setId(null);
        return userRepositoryJpa.save(user);
    }

    public List<UserJPA> readAll() {
        return userRepositoryJpa.findAll();
    }

    public User readOne(Long id) {
        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);

        if (userRedis.isPresent()){
            return convertData(userRedis.get());
        }else {
            UserJPA userFromDb = userRepositoryJpa.getReferenceById(id);
            userRepositoryRedis.save(convertData(userFromDb));
            return userFromDb;
        }

    }

    public User update(Long id, UserJPA user) {
        if (user==null)return null;
        user.setId(id);
        UserJPA newUser = userRepositoryJpa.save(user);

        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if (userRedis.isPresent()){
            //userRepositoryRedis.deleteById(id);// Faster update - Slower read
            userRepositoryRedis.save(convertData(newUser));// Faster read - Slower update


        }


        return user;
    }

    public void delete(Long id) {
        userRepositoryJpa.deleteById(id);
        userRepositoryRedis.deleteById(id);
    }
}
