package com.parkingsystem.parking.service.abstraction;


/**
 *
 * @author sunny.ansal
 *
 */

public interface RedisService {


    public void addAvailableSlot(String key , Long slotId);

    public Long getAvailableSlot(String key);

    public void releaseSlot(String key, Long slotId);
}
