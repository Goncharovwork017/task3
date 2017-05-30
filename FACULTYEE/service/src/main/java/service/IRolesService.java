package service;

import entities.Roles;

import java.util.Set;

/**
 * Created by ivan on 14.05.2017.
 */
public interface IRolesService extends IService<Roles> {


    Set<Roles> getRolesById(int id);

}
