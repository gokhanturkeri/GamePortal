package com.GamePortal.Controller;

import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Entity.UserInformation;
import com.GamePortal.Repository.IGameInformationRepository;
import com.GamePortal.Repository.IUserInformationRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users/games")
public class UsersGameController {

    private IGameInformationRepository gameInformationRepository;
    private IUserInformationRepository userInformationRepository;

    public UsersGameController(IUserInformationRepository userInformationRepository,
                               IGameInformationRepository gameInformationRepository) {
        this.gameInformationRepository = gameInformationRepository;
        this.userInformationRepository = userInformationRepository;
    }

    @PutMapping("/{gameId}/user/{userId}")
    public GameInformation enrollUserToGame(
            @PathVariable Long gameId,
            @PathVariable Long userId
    ){
        GameInformation game = gameInformationRepository.findById(gameId).get();
        UserInformation user = userInformationRepository.findById(userId).get();
        game.usersGame(user);

        if(user.getUserCredit() > game.getGameCost()) {
            user.setUserCredit(user.getUserCredit() - game.getGameCost());
        }
        else{
            return null;
        }

        return gameInformationRepository.save(game);
    }

}