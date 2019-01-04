package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Level;
import zw.co.deepkah.voucher.dto.LevelDto;
import zw.co.deepkah.voucher.service.LevelService;

import java.util.Optional;

@AllArgsConstructor
@Component
public class LevelMutationResolver implements GraphQLMutationResolver {

    private LevelService levelService;

    public Level createLevel(LevelDto levelDto){
        Level level = new Level();
        level.setName(levelDto.getName());
        level.setDescription(levelDto.getDescription());
        return levelService.save(level);
    }

    public Level updateLevel(LevelDto levelDto, Optional<String> levelId){

       Level level = new Level();
       if(levelId.isPresent()){

           level  = levelService.getOne(levelId.get()).get();
           level.setName(levelDto.getName());
           level.setDescription(levelDto.getDescription());

                            }
        return levelService.save(level);
    }
}
