package jw.hospital.hosp.repository;

import jw.hospital.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {
    //判断是否存在数据
    //getHospitalByHoscode根据命名规范实现的方法(不用sql语句，有点mp的意思)：根据Hoscode的值获取Hospital对象
    Hospital getHospitalByHoscode(String hoscode);

    //根据医院名称查询
    List<Hospital> findHospitalByHosnameLike(String hosname);

    Hospital findByHoscodeLike(String name);

}
