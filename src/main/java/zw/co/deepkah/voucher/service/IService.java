package zw.co.deepkah.voucher.service;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IService<T> {

    default T findByName(String name){
        T t = null;
        return t;
        }
        Optional<List<T>> findAll();
        Optional<T> getOne(String Id);
        void removeById(String Id);
        void remove(T t);
        T save(T t);

    default  void init(){}

    default void store(MultipartFile file) throws Exception {
        System.out.println(file.getName());
    }

    default Stream<Path> loadAll(){
        Path path = null;
      return (Stream<Path>) path;
    }

    default  Path load(String filename){
        Path path = null;
        return path;
    }

    default Resource loadAsResource(String filename){
     Resource resource= null;
     return resource;
    }


}
