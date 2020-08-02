package com.backroads.repository;

import com.backroads.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
//        @Query("SELECT d FROM Destination d WHERE "
//                + "(:location_id IS NULL or d.location.ind_search like :location_id ) AND "
//                + "(:season_id IS NULL or d.season.ind_search like :season_id )")
//        @Query("select d from Destination  d where d.location.ind_search like '3' and d.season.ind_search like '1'")
        @Query("select d from Destination  d where trim(d.location.location_id) like :location_id and  trim(d.season.season_id) like :season_id")
        Page<Destination>search(@Param("location_id") String location_id,
                                @Param("season_id") String season_id,
                                Pageable pageable);


}
