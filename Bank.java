import java.util.Scanner;
public class AccountTest
{
	

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		
		String cmd = "";
		int cmd_int = 0;
		do 
		{
			
		System.out.println("***Main Menu***");
		System.out.println("1) 開戶");
		System.out.println("2) 存款");
		System.out.println("3) 提款");
		System.out.println("4) 目前餘額");
		System.out.println("0) Exit");
		System.out.println("Please enter a number in [1,2,3,4,0]");
		
		
		try
		{
			 cmd = scanner.nextLine(); //讓使用者輸入想要的功能代碼
			 cmd_int = Integer.parseInt(cmd); /*將其轉為整數，若失敗則會拋出
			 				NumberFormatException*/
		}
		catch(NumberFormatException e)
		{
			System.err.println(e.getMessage()); //顯示錯誤訊息
			System.err.println("請輸入0~4的數字！"); //提醒使用者正確輸入
			continue; //迴圈重新開始
		}
		
			
			
			
			
		switch(cmd)
		{
		case "1":
			System.out.println("開戶，請輸入您要存入的初始金額（最低1000）");
			double initM = 0.0;
					
			try
			{
			 initM = scanner.nextDouble();
			 if(initM>=1000.0)
			 {
				 Account account = new Account(initM);
			 }
			}
			catch(Exception e)
			{
				System.err.println("您必須輸入一個大於1000的數字！程式已回到主選單，請重新選擇");
			
			}
			break;
		}
		
		
		}while(!cmd.equals("0")); //若輸入非0，則迴圈繼續執行
		
	}
}
 class Account
{
	private double money = 0.0;
	
	public Account(double money)
	{
		this.money = money;
	}
	
	public void addMoney(double money)
	{
		this.money += money;
	}
	
	public void takeMoney(double money)
	{
		this.money -= money;
	}
	
	public double checkMoney()
	{
		return this.money;
	}
}
