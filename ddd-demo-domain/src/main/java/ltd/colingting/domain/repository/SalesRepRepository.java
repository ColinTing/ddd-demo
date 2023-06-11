package ltd.colingting.domain.repository;


import ltd.colingting.domain.entity.SalesRep;

/**
 * @author 丁浩
 * @date 2022年07月23日 18:23
 */

public interface SalesRepRepository {


    SalesRep findRep(String areaCode);
}
