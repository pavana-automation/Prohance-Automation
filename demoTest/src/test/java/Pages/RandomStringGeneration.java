package Pages;

import java.util.Random;


public class RandomStringGeneration{
	
	
	public String randomStringGenerator()
	{
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		StringBuilder sb = new StringBuilder();
		
		Random random = new Random();
		
		int length=7;
		for(int i=0;i<length;i++)
		{
			int index = random.nextInt(alphabet.length());
			
			char randomChar = alphabet.charAt(index);
			
			sb.append(randomChar);
		}
		
		String randomString = sb.toString();
		System.out.println("Random String is" +randomString);
		//char[] charArr = randomString.toCharArray();
		return randomString;
	}

}
