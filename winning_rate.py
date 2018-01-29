import requests,re

headers={
	'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36',
}

r1 = requests.get("http://dotamax.com/hero/rate/", headers=headers)

content = r1.text
resName = r'<tr onclick=.*?><td style="width: 30%"><img class=.*?></img><span class="hero-name-list">(.*?)</span></td>.*?</tr>'
names = re.findall(resName,content,re.I|re.S|re.M)
resRate = r'<tr onclick=.*?><td .*?</td><td style="width: 40%"><div style="height: 10px">(.*?)</div>.*?</td>.*?</tr>'
rate= re.findall(resRate,content,re.I|re.S|re.M)
resLink = r'<tr onclick="DoNav(.*?)" style="cursor: pointer;">'
link=  re.findall(resLink,content,re.I|re.S|re.M)

antiLinks=[]
combLinks=[]

for i in range(0,115):
	link[i]=link[i][15:len(link[i])-2]
	rate[i]=float(rate[i][:len(rate[i])-1])
	print(names[i]+" "+str(rate[i])+" "+link[i])
	antiLinks.append("http://dotamax.com/hero/detail/match_up_anti/"+link[i])
	combLinks.append("http://dotamax.com/hero/detail/match_up_comb/"+link[i])


for i in range(0,115):
	with open("douban.txt","a") as f:
		f.write("a "+names[i]+" "+str(rate[i])+"\r\n")
	r1=requests.get(antiLinks[i], headers=headers)
	content=r1.text
	resName=r'<tr><td><a href=.*?><span class="hero-name-list">(.*?)</span></td>.*?</tr>'
	antiNames=re.findall(resName,content,re.I|re.S|re.M)
	resRate=r'<tr><td>.*?--><td><div style="height: 10px">(.*?)</div>.*?</td>.*?</tr>'
	antiRate=re.findall(resRate,content,re.I|re.S|re.M)

	r2=requests.get(combLinks[i], headers=headers)
	content=r2.text
	resName=r'<tr><td><a href=.*?><span class="hero-name-list">(.*?)</span></td>.*?</tr>'
	combNames=re.findall(resName,content,re.I|re.S|re.M)
	resRate=r'<tr><td>.*?--><td><div style="height: 10px">(.*?)</div>.*?</td>.*?</tr>'
	combRate=re.findall(resRate,content,re.I|re.S|re.M)

	for j in range(0,114):
		antiRate[j]=round(float(antiRate[j][:len(antiRate[j])-1])-rate[i],2)
		combRate[j]=round(float(combRate[j][:len(combRate[j])-1])-rate[i],2)
		with open("douban.txt","a") as f:
			f.write(combNames[j]+" "+str(antiRate[j])+" "+str(combRate[j])+"\r\n")
	print(i)
	



