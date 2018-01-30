package dota2HeroRecommand;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Recommand {

	public static void main(String[] args) {
		String[] names=new String[115];
		names[0]="敌法师";
		names[1]="斧王";
		names[2]="祸乱之源";
		names[3]="嗜血狂魔";
		names[4]="水晶室女";
		names[5]="卓尔游侠";
		names[6]="撼地者";
		names[7]="主宰";
		names[8]="米拉娜";
		names[9]="变体精灵";
		names[10]="影魔";
		names[11]="幻影长矛手";
		names[12]="帕克";
		names[13]="帕吉";
		names[14]="剃刀";
		names[15]="沙王";
		names[16]="风暴之灵";
		names[17]="斯温";
		names[18]="小小";
		names[19]="复仇之魂";
		names[20]="风行者";
		names[21]="宙斯";
		names[22]="昆卡";
		names[23]="莉娜";
		names[24]="莱恩";
		names[25]="暗影萨满";
		names[26]="斯拉达";
		names[27]="潮汐猎人";
		names[28]="巫医";
		names[29]="巫妖";
		names[30]="力丸";
		names[31]="谜团";
		names[32]="修补匠";
		names[33]="狙击手";
		names[34]="瘟疫法师";
		names[35]="术士";
		names[36]="兽王";
		names[37]="痛苦女王";
		names[38]="剧毒术士";
		names[39]="虚空假面";
		names[40]="冥魂大帝";
		names[41]="死亡先知";
		names[42]="幻影刺客";
		names[43]="帕格纳";
		names[44]="圣堂刺客";
		names[45]="冥界亚龙";
		names[46]="露娜";
		names[47]="龙骑士";
		names[48]="戴泽";
		names[49]="发条技师";
		names[50]="拉席克";
		names[51]="先知";
		names[52]="噬魂鬼";
		names[53]="黑暗贤者";
		names[54]="克林克兹";
		names[55]="全能骑士";
		names[56]="魅惑魔女";
		names[57]="哈斯卡";
		names[58]="暗夜魔王";
		names[59]="育母蜘蛛";
		names[60]="赏金猎人";
		names[61]="编织者";
		names[62]="杰奇洛";
		names[63]="蝙蝠骑士";
		names[64]="陈";
		names[65]="幽鬼";
		names[66]="远古冰魄";
		names[67]="末日使者";
		names[68]="熊战士";
		names[69]="裂魂人";
		names[70]="矮人直升机";
		names[71]="炼金术士";
		names[72]="祈求者";
		names[73]="沉默术士";
		names[74]="殁境神蚀者";
		names[75]="狼人";
		names[76]="酒仙";
		names[77]="暗影恶魔";
		names[78]="德鲁伊";
		names[79]="混沌骑士";
		names[80]="米波";
		names[81]="树精卫士";
		names[82]="食人魔魔法师";
		names[83]="不朽尸王";
		names[84]="拉比克";
		names[85]="干扰者";
		names[86]="司夜刺客";
		names[87]="娜迦海妖";
		names[88]="光之守卫";
		names[89]="艾欧";
		names[90]="维萨吉";
		names[91]="斯拉克";
		names[92]="美杜莎";
		names[93]="巨魔战将";
		names[94]="半人马战行者";
		names[95]="马格纳斯";
		names[96]="伐木机";
		names[97]="钢背兽";
		names[98]="巨牙海民";
		names[99]="天怒法师";
		names[100]="亚巴顿";
		names[101]="上古巨神";
		names[102]="军团指挥官";
		names[103]="工程师";
		names[104]="灰烬之灵";
		names[105]="大地之灵";
		names[106]="孽主";
		names[107]="恐怖利刃";
		names[108]="凤凰";
		names[109]="神谕者";
		names[110]="寒冬飞龙";
		names[111]="天穹守望者";
		names[112]="齐天大圣";
		names[113]="邪影芳灵";
		names[114]="石鳞剑士";
		
		double[][] combRate=new double[115][115];
		double[][] antiRate=new double[115][115];
		ArrayList<String> f= new ArrayList<String>();
		double[] oRate=new double[115];
		
		try {
			String pathname="D:\\工作与学习\\悉尼大学\\self learning\\python\\爬英雄胜率\\rate.txt";
			File file=new File(pathname);
			Scanner reader = new Scanner(file);			
			while(reader.hasNextLine()) {
				f.add(reader.nextLine());
				String s=reader.nextLine();
			}		
		}catch(Exception e) {}
		

		int i=-1;
		while(i<f.size()-1) {
			i++;
			if(f.get(i).startsWith("a")) {
				int sofH=0;
				for(int m=0;m<115;m++) {
					if(names[m].equals(f.get(i).split(" ")[1])) {
						oRate[m]=Double.parseDouble(f.get(i).split(" ")[2]);
						sofH=m;
						break;
					}
				}
				for(int j=0;j<114;j++) {
					i++;
					for(int mm=0;mm<115;mm++) {
						if(names[mm].equals(f.get(i).split(" ")[0])) {
							antiRate[sofH][mm]=Double.parseDouble(f.get(i).split(" ")[1]);
							combRate[sofH][mm]=Double.parseDouble(f.get(i).split(" ")[2]);
							break;
							}
					}					
				}
			}
		}
		

		
		ArrayList<Integer> enemy=new ArrayList<Integer>();
		ArrayList<Integer> friend = new ArrayList<Integer>();

		String[] heroList=new String[116];
		heroList[0]="none";
		for(int j=0;j<115;j++) {
			heroList[j+1]=names[j];
		}
		
		Object[] numbers=new Object[6];
		numbers[0]=0;
		numbers[1]=1;
		numbers[2]=2;
		numbers[3]=3;
		numbers[4]=4;
		numbers[5]=5;
		
		int nofE= (int) JOptionPane.showInputDialog(null, "choose number of enemys", "Enemy", JOptionPane.INFORMATION_MESSAGE, null,numbers, numbers[0]);
		String zhenrong="";
		if(nofE>0) {
			zhenrong="Enemy: ";
			for(int j=0;j<nofE;j++) {
				String choice=(String) JOptionPane.showInputDialog(null, zhenrong+"choose "+(j+1)+"th enemy ", "Enemy", JOptionPane.INFORMATION_MESSAGE, null, heroList, "none");
				zhenrong=zhenrong+choice+" ";
				if(!choice.equals("none")) {
					int l=heroList.length;
					String[] oldList=new String[l];
					for(int k=0;k<l;k++) {
						oldList[k]=heroList[k];
					}
					heroList=new String[l-1];
					int flag=0;
					for(int k=0;k<l-1;k++) {
						if(flag==0) {
							if(choice.equals(oldList[k])) {
								heroList[k]=oldList[k+1];
								flag=1;
							}else {heroList[k]=oldList[k];}
						}else {heroList[k]=oldList[k+1];}						
					}
				}
				for(int k=0;k<115;k++) {
					if(choice.equals(names[k])) {
						enemy.add(k);
						break;
					}
				}
			}
		}
		
		numbers=new Object[5];
		numbers[0]=0;
		numbers[1]=1;
		numbers[2]=2;
		numbers[3]=3;
		numbers[4]=4;
		
		int nofF= (int) JOptionPane.showInputDialog(null, "choose number of friends", "Friend", JOptionPane.INFORMATION_MESSAGE, null,numbers, numbers[0]);
		
		if(nofF>0) {
			zhenrong=zhenrong+"Friends: ";
			for(int j=0;j<nofF;j++) {
				String choice=(String) JOptionPane.showInputDialog(null, zhenrong+"choose "+(j+1)+"th friend.", "Friend", JOptionPane.INFORMATION_MESSAGE, null, heroList, "none");
				zhenrong=zhenrong+choice+" ";
				if(!choice.equals("none")) {
					int l=heroList.length;
					String[] oldList=new String[l];
					for(int k=0;k<l;k++) {
						oldList[k]=heroList[k];
					}
					heroList=new String[l-1];
					int flag=0;
					for(int k=0;k<l-1;k++) {
						if(flag==0) {
							if(choice.equals(oldList[k])) {
								heroList[k]=oldList[k+1];
								flag=1;
							}else {heroList[k]=oldList[k];}
						}else {heroList[k]=oldList[k+1];}						
					}
				}
				for(int k=0;k<115;k++) {
					if(choice.equals(names[k])) {
						friend.add(k);
						break;
					}
				}
			}
		}
		
		
		
		double[] winRate=new double[115];
		int[] winS= new int[115];
		
		for(int m=0;m<115;m++) {
			winRate[m]=oRate[m];
			for(int j=0;j<enemy.size();j++) {
				winRate[m]=winRate[m]+antiRate[m][enemy.get(j)]/(enemy.size()+friend.size());
			}
			for(int k=0;k<friend.size();k++) {
				winRate[m]=winRate[m]+combRate[m][friend.get(k)]/(enemy.size()+friend.size());
			}
			for(int j=0;j<enemy.size();j++) {
				if(m==enemy.get(j)) {
					winRate[m]=0;
				}
			}
			for(int k=0;k<friend.size();k++) {
				if(m==friend.get(k)) {
					winRate[m]=0;
				}
			}
			winRate[m]=(Math.round(winRate[m]*100))/100.0;
		}
		
		double[] winRate2=new double[115];
		
		for(int j=0;j<115;j++) {
			double max=winRate[j];
			int maxIndex=j;
			for(int k=0;k<115;k++) {
				if(winRate[k]>max) {
					max=winRate[k];
					maxIndex=k;
				}
			}			
			winRate[maxIndex]=-1;
			winRate2[j]=max;
			winS[j]=maxIndex;
		}
		
		String output="";
		for(int j=0;j<115;j++) {
			if(j<30) {
				output=output+winS[j]+" "+names[winS[j]]+" "+winRate2[j]+"\r\n";
			}
			System.out.println(winS[j]+" "+names[winS[j]]+" "+winRate2[j]);
		}
		
		JOptionPane.showMessageDialog(null, output, "recommand", JOptionPane.NO_OPTION);
	}

}
