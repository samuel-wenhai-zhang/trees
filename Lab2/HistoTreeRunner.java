//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

public class HistoTreeRunner
{
	public static void main(String[] args)
	{
		HistoTree<Character> test1 = new HistoTree<Character>();
		test1.addData('A');
		test1.addData('A');
		test1.addData('A');
		test1.addData('A');
		test1.addData('B');
		test1.addData('V');
		test1.addData('S');
		test1.addData('E');
		test1.addData('A');
		test1.addData('S');
		test1.addData('A');
		test1.addData('A');
		test1.addData('V');
		test1.addData('S');
		test1.addData('E');
		test1.addData('A');
		System.out.println(test1);
		System.out.println(test1.search('A').getData());
		System.out.println(test1.search('V').getData());

		HistoTree<Integer> test2 = new HistoTree<Integer>();
		test2.addData(1);
		test2.addData(2);
		test2.addData(3);
		test2.addData(11);
		test2.addData(22);
		test2.addData(32);
		test2.addData(1);
		test2.addData(22);
		test2.addData(13);
		System.out.println(test2);
		System.out.println(test2.search(1).getData());
		System.out.println(test2.search(13).getData());


		HistoTree<String> test3 = new HistoTree<String>();
		test3.addData("abc");
		test3.addData("ead");
		test3.addData("xyz");
		test3.addData("xyz");
		test3.addData("abc");
		test3.addData("ead");
		test3.addData("abc");
		test3.addData("2342");
		test3.addData("x2y2z");
		System.out.println(test3);
		System.out.println(test3.search("abc").getData());
		System.out.println(test3.search("2342").getData());

	}
}