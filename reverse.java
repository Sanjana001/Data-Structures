class reverse{
	    static int l=0;
		static int p=0;
		static int j;
		static int s=0;
		static void revWordsString(char[] str){
			int i=0;
			int ct = str.length;
            while(i<ct){
				if(str[i]!=' ' && i!=ct)s++;
                else{
					j=i-1;
                    while(l<s/2){
						char ch=str[j];
                        str[j]=str[p];
                        str[p]=ch;
                        p++;
                        j--;
                        l++;
                    }
                    s=0;
                    p=i+1;
                    l=0;
              }
              i++;
         }
         System.out.println(str);
}
	public static void main(String[] args){
		String str = "Hello, my name is sanjana";
		char ch[] = str.toCharArray();
		revWordsString(ch);
	}
}