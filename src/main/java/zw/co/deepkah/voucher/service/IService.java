package zw.co.deepkah.voucher.service;

import java.util.List;
import java.util.Optional;

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
}
