import java.util.Scanner;
public class AccountTest
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);		
		
		String cmd = ""; //宣告變數，用於儲存使用者輸入的數字，以決定執行何項功能
		int cmd_int = 0; // 用於儲存將使用者輸入轉為數字的變數
		do 
		{			
			
		System.out.println("***Main Menu***");  			//主選單訊息
		System.out.println("1) 開戶");				       //主選單訊息
		System.out.println("2) 存款");				       //主選單訊息
		System.out.println("3) 提款");				       //主選單訊息
		System.out.println("4) 目前餘額");				     //主選單訊息
		System.out.println("0) Exit");					//主選單訊息
		System.out.println("Please enter a number in [1,2,3,4,0]");	//主選單訊息 
		
		try
		{
			 cmd = scanner.nextLine(); //讓使用者輸入想要的功能代碼
			 cmd_int = Integer.parseInt(cmd); /*將其轉為整數，若失敗則會拋出
			 				NumberFormatException，藉此保證使用者輸入的是數字*/
		}
		catch(NumberFormatException e)
		{
			System.err.println(e.getMessage()); //顯示錯誤訊息
			System.err.println("請輸入0~4的數字！"); //提醒使用者正確輸入
			continue; //迴圈重新開始
		}	
			
			
			
		switch(cmd) //根據使用者輸入的數字，執行對應的功能
		{
		case "1":
			System.out.println("開戶，請輸入您要存入的初始金額（最低1000）");
			double initM = 0.0; //開戶時要存入帳戶的初始金額
					
			try
			{
			 initM = scanner.nextDouble(); //讓使用者輸入初始金額
			 if(initM>=1000.0) //若>1000才開戶
			 {
				 Account account = new Account(initM); //建構式，創造新的帳戶
				 System.out.println("開戶成功！帳戶目前有" +account.checkMoney());
			 }
			}
			catch(Exception e) //若使用者輸入的不是數字，則會產生Exception
			{
				System.err.println("您必須輸入一個數字！程式已回到主選單，請重新選擇");
			}
			break;
		}
		}while(!cmd.equals("0")); //若輸入非0，則迴圈繼續執行
		
	}
}
 class Account //帳戶的Class
{
	private double money = 0.0; //帳戶內的餘額
	
	public Account(double money)
	{
		this.money = money;  //建構式，用於開戶
	}
	
	public void addMoney(double money) //存款功能
	{
		this.money += money;
	}
	
	public void takeMoney(double money) //提款功能
	{
		this.money -= money;
	}
	
	public double checkMoney() //查看餘額功能
	{
		return this.money;
	}
}
