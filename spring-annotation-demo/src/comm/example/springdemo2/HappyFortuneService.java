package comm.example.springdemo2;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import comm.example.springdemo.FortuneService;

@Component

public class HappyFortuneService implements FortuneService {
	
		public String getFortune()
	{   
			
		return "happyfortune";
	}
	
}