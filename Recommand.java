package dota2HeroRecommand;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Recommand {

	public static void main(String[] args) {
		String[] names=new String[115];
		names[0]="�з�ʦ";
		names[1]="����";
		names[2]="����֮Դ";
		names[3]="��Ѫ��ħ";
		names[4]="ˮ����Ů";
		names[5]="׿������";
		names[6]="������";
		names[7]="����";
		names[8]="������";
		names[9]="���徫��";
		names[10]="Ӱħ";
		names[11]="��Ӱ��ì��";
		names[12]="����";
		names[13]="����";
		names[14]="�굶";
		names[15]="ɳ��";
		names[16]="�籩֮��";
		names[17]="˹��";
		names[18]="СС";
		names[19]="����֮��";
		names[20]="������";
		names[21]="��˹";
		names[22]="����";
		names[23]="����";
		names[24]="����";
		names[25]="��Ӱ����";
		names[26]="˹����";
		names[27]="��ϫ����";
		names[28]="��ҽ";
		names[29]="����";
		names[30]="����";
		names[31]="����";
		names[32]="�޲���";
		names[33]="�ѻ���";
		names[34]="���߷�ʦ";
		names[35]="��ʿ";
		names[36]="����";
		names[37]="ʹ��Ů��";
		names[38]="�綾��ʿ";
		names[39]="��ռ���";
		names[40]="ڤ����";
		names[41]="������֪";
		names[42]="��Ӱ�̿�";
		names[43]="������";
		names[44]="ʥ�ô̿�";
		names[45]="ڤ������";
		names[46]="¶��";
		names[47]="����ʿ";
		names[48]="����";
		names[49]="������ʦ";
		names[50]="��ϯ��";
		names[51]="��֪";
		names[52]="�ɻ��";
		names[53]="�ڰ�����";
		names[54]="���ֿ���";
		names[55]="ȫ����ʿ";
		names[56]="�Ȼ�ħŮ";
		names[57]="��˹��";
		names[58]="��ҹħ��";
		names[59]="��ĸ֩��";
		names[60]="�ͽ�����";
		names[61]="��֯��";
		names[62]="������";
		names[63]="������ʿ";
		names[64]="��";
		names[65]="�Ĺ�";
		names[66]="Զ�ű���";
		names[67]="ĩ��ʹ��";
		names[68]="��սʿ";
		names[69]="�ѻ���";
		names[70]="����ֱ����";
		names[71]="������ʿ";
		names[72]="������";
		names[73]="��Ĭ��ʿ";
		names[74]="�⾳��ʴ��";
		names[75]="����";
		names[76]="����";
		names[77]="��Ӱ��ħ";
		names[78]="��³��";
		names[79]="������ʿ";
		names[80]="�ײ�";
		names[81]="������ʿ";
		names[82]="ʳ��ħħ��ʦ";
		names[83]="����ʬ��";
		names[84]="���ȿ�";
		names[85]="������";
		names[86]="˾ҹ�̿�";
		names[87]="���Ⱥ���";
		names[88]="��֮����";
		names[89]="��ŷ";
		names[90]="ά����";
		names[91]="˹����";
		names[92]="����ɯ";
		names[93]="��ħս��";
		names[94]="������ս����";
		names[95]="�����˹";
		names[96]="��ľ��";
		names[97]="�ֱ���";
		names[98]="��������";
		names[99]="��ŭ��ʦ";
		names[100]="�ǰͶ�";
		names[101]="�Ϲž���";
		names[102]="����ָ�ӹ�";
		names[103]="����ʦ";
		names[104]="�ҽ�֮��";
		names[105]="���֮��";
		names[106]="����";
		names[107]="�ֲ�����";
		names[108]="���";
		names[109]="������";
		names[110]="��������";
		names[111]="���������";
		names[112]="�����ʥ";
		names[113]="аӰ����";
		names[114]="ʯ�۽�ʿ";
		
		double[][] combRate=new double[115][115];
		double[][] antiRate=new double[115][115];
		ArrayList<String> f= new ArrayList<String>();
		double[] oRate=new double[115];
		
		try {
			String pathname="D:\\������ѧϰ\\Ϥ���ѧ\\self learning\\python\\��Ӣ��ʤ��\\rate.txt";
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
