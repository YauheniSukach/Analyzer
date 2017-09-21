public class CountingWords {
    public void ParticleRemove(String[] a) {
        for (int i = 0; i < a.length; i++) {
            // замена английских местоимений,предлогов и союзов на пробелы.
            if (("a,the,aboard,above,absent,across,after,against,along,amid,amidst,among,amongst,around,as,aside,aslant,astride,at,athwart,atop,bar,before,behind,below,beneath,beside,besides,between,betwixt,beyond,but,by,circa,despite,down,except,for,from,given,in,inside,into,like,mid,minus,near,neath,next,notwithstanding,of,off,on,opposite,out,outside,over,pace,per,plus,post,pro,qua,round,save,since,than,through,till,times,to,toward,towards,under,underneath,unlike,until,up,versus,via,vice,with,without,and,but,or,while,whereas,that,if,whether,after,as,since,until,when,while,because,for,so,unless,than,through,who,whose,what,which,when,where,how,why,i,you,he,she,it,we,you,they,me,him,her,us,them,my,your,his,her,its,our,your,their,mine,yours,his,hers,ours,yours,theirs,myself,yourself,himself,herself,itself,ourselves,yourselves,themselves,other,another,this,such,same,who,no,none,neither,nobody,nothing,some,somebody,something,anybody,anything,one,all,both,either,each,every,everybody,everything," +
                    "other,many,few,several").indexOf(a[i]) != -1) {
                a[i] = "";
            }
        }
    }
    public void Sort(String[] a) {
        //сортировка слов
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j].length() > a[j + 1].length()) {
                    String b = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = b;
                }
            }
        }
    }

    public void CountingMax(String[] a) {
        //подсчет кол-ва одинаковых слов
        int[] num = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            num[i] = 1;
            for (int j = 0; j < a.length; j++) {
                if ((a[i].equals(a[j])) & (i != j)) {//если встретилось повторяющие слово,то заменяем его на пробел и увеличиваем его кол-во
                    a[j] = "";
                    num[i]++;
                }
            }
        }
        //вывод топ-10 самых встречающихся слов
        for (int i = 0; i < 10; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < num.length; j++) {
                //находим максимальное кол-во слова и проверяем или это слово не является пробелом
                if (num[j] > max & a[j] != "") {
                    max = num[j];
                    //записываем индекс этого максимального кол-ва
                    index = j;
                }
            }
            // проверка, что слово с максимальным кол-вом  не является пробелом
            if(a[index]=="") {
                break;
            }else {
                //
                System.out.println("Word:" +
                        a[index] + " - " + num[index]);
                //замена слова с максимальным кол-вом на пробел
                a[index] = "";
            }
        }

    }
}
