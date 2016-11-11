import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SearchGUI {

	private JFrame frame;
	private JTextField query;
	//Instantiate fo class
	FileOperation fileOperationLinear = new FileOperation();
	FileOperation fileOperationQuadratic = new FileOperation();
	FileOperation fileOperationDouble = new FileOperation();
	FileOperation fileOperationChaining = new FileOperation();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI window = new SearchGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		query = new JTextField();
		query.setBounds(643, 26, 345, 20);
		frame.getContentPane().add(query);
		query.setColumns(10);
		
		
		//Building Tables
		fileOperationLinear.readWords("/Users/berk/workspace/TextBasedSearchEngine/src/txt/",2);
		fileOperationQuadratic.readWords("/Users/berk/workspace/TextBasedSearchEngine/src/txt/",1);
		fileOperationDouble.readWords("/Users/berk/workspace/TextBasedSearchEngine/src/txt/",3);
		fileOperationChaining.readWords("/Users/berk/workspace/TextBasedSearchEngine/src/txt/",4);
		
		
		
		JRadioButton rdbtnQuicksort = new JRadioButton("QuickSort");
		rdbtnQuicksort.setBounds(50, 131, 109, 23);
		frame.getContentPane().add(rdbtnQuicksort);
		
		JRadioButton rdbtnMergesort = new JRadioButton("MergeSort");
		rdbtnMergesort.setBounds(50, 157, 109, 23);
		frame.getContentPane().add(rdbtnMergesort);
		
		JRadioButton rdbtnInsertionsort = new JRadioButton("InsertionSort");
		rdbtnInsertionsort.setBounds(50, 199, 109, 23);
		frame.getContentPane().add(rdbtnInsertionsort);
		
		JRadioButton rdbtnRadixsort = new JRadioButton("RadixSort");
		rdbtnRadixsort.setBounds(50, 225, 109, 23);
		frame.getContentPane().add(rdbtnRadixsort);
		
		JRadioButton rdbtnSelectionsort = new JRadioButton("SelectionSort");
		rdbtnSelectionsort.setBounds(50, 251, 109, 23);
		frame.getContentPane().add(rdbtnSelectionsort);
		
		JRadioButton rdbtnBubblesort = new JRadioButton("BubbleSort");
		rdbtnBubblesort.setBounds(50, 277, 109, 23);
		frame.getContentPane().add(rdbtnBubblesort);
		
		JLabel lblDivideAndConquer = new JLabel("Divide And Conquer Methods");
		lblDivideAndConquer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDivideAndConquer.setBounds(50, 110, 184, 14);
		frame.getContentPane().add(lblDivideAndConquer);
		
		JLabel lblIterativeMethods = new JLabel("Iterative Methods");
		lblIterativeMethods.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblIterativeMethods.setBounds(50, 188, 169, 14);
		frame.getContentPane().add(lblIterativeMethods);
		
		JRadioButton rdbtnChaining = new JRadioButton("Chaining");
		rdbtnChaining.setBounds(50, 26, 109, 23);
		frame.getContentPane().add(rdbtnChaining);
		
		JRadioButton rdbtnOpenaddressinglinearProbing = new JRadioButton("Linear Probing");
		rdbtnOpenaddressinglinearProbing.setBounds(161, 25, 129, 23);
		frame.getContentPane().add(rdbtnOpenaddressinglinearProbing);
		
		JRadioButton rdbtnQuadraticProbing = new JRadioButton("Quadratic Probing");
		rdbtnQuadraticProbing.setBounds(292, 25, 148, 23);
		frame.getContentPane().add(rdbtnQuadraticProbing);
		
		JRadioButton rdbtnDoubleHashing = new JRadioButton("Double Hashing");
		rdbtnDoubleHashing.setBounds(442, 25, 126, 23);
		frame.getContentPane().add(rdbtnDoubleHashing);
		
		JLabel lblTypeOfHashtable = new JLabel(" Type of HashTable ");
		lblTypeOfHashtable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTypeOfHashtable.setBounds(50, 5, 387, 14);
		frame.getContentPane().add(lblTypeOfHashtable);
		
		JLabel lblLinarProbing = new JLabel("Linear Probing");
		lblLinarProbing.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLinarProbing.setBounds(308, 110, 110, 23);
		frame.getContentPane().add(lblLinarProbing);
		
		JLabel lblQuadraticProbing = new JLabel("Quadratic Probing");
		lblQuadraticProbing.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblQuadraticProbing.setBounds(538, 110, 126, 23);
		frame.getContentPane().add(lblQuadraticProbing);
		
		JLabel lblDoubleHashing = new JLabel("Double Hashing");
		lblDoubleHashing.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDoubleHashing.setBounds(755, 110, 117, 23);
		frame.getContentPane().add(lblDoubleHashing);
		
		JLabel lblChaining = new JLabel("Chaining");
		lblChaining.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblChaining.setBounds(985, 110, 152, 23);
		frame.getContentPane().add(lblChaining);
		
		JLabel lblInitializationTimeLinear = new JLabel("Initialization Time : " + (fileOperationLinear.end - fileOperationLinear.start) / 1000f );
		lblInitializationTimeLinear.setBounds(308, 166, 169, 14);
		frame.getContentPane().add(lblInitializationTimeLinear);
		
		JLabel lblInitializationTimeQuadratic = new JLabel("Initialization Time : " + (fileOperationQuadratic.end - fileOperationQuadratic.start) / 1000f);
		lblInitializationTimeQuadratic.setBounds(538, 161, 177, 14);
		frame.getContentPane().add(lblInitializationTimeQuadratic);
		
		JLabel lblInitializationTimeDouble = new JLabel("Initialization Time : " + (fileOperationDouble.end - fileOperationDouble.start) / 1000f);
		lblInitializationTimeDouble.setBounds(755, 161, 163, 14);
		frame.getContentPane().add(lblInitializationTimeDouble);
		
		JLabel lblInitializationTimeChaining = new JLabel("Initialization Time : " + (fileOperationChaining.end - fileOperationChaining.start) / 1000f);
		lblInitializationTimeChaining.setBounds(985, 161, 152, 14);
		frame.getContentPane().add(lblInitializationTimeChaining);
		
		JLabel lblReadWordsLinear = new JLabel("Read Words : " + fileOperationLinear.counter );
		lblReadWordsLinear.setBounds(308, 203, 152, 14);
		frame.getContentPane().add(lblReadWordsLinear);
		
		JLabel lblReadWordsQuadratic = new JLabel("Read Words : " + fileOperationQuadratic.counter);
		lblReadWordsQuadratic.setBounds(538, 203, 163, 14);
		frame.getContentPane().add(lblReadWordsQuadratic);
		
		JLabel lblReadWordsDouble = new JLabel("Read Words : " + fileOperationDouble.counter);
		lblReadWordsDouble.setBounds(755, 203, 163, 14);
		frame.getContentPane().add(lblReadWordsDouble);
		
		JLabel lblReadWordsChaining = new JLabel("Read Words : " + fileOperationChaining.counter);
		lblReadWordsChaining.setBounds(985, 203, 152, 14);
		frame.getContentPane().add(lblReadWordsChaining);
		
		JLabel lblTableSizeLinear = new JLabel("Table Size : " + fileOperationLinear.oa.getTableSize());
		lblTableSizeLinear.setBounds(308, 260, 110, 14);
		frame.getContentPane().add(lblTableSizeLinear);
		
		JLabel lblTableSizeQuadratic = new JLabel("Table Size : " + fileOperationQuadratic.oa.getTableSize());
		lblTableSizeQuadratic.setBounds(538, 260, 126, 14);
		frame.getContentPane().add(lblTableSizeQuadratic);
		
		JLabel lblTableSizeDouble = new JLabel("Table Size : " + fileOperationDouble.oa.getTableSize());
		lblTableSizeDouble.setBounds(755, 255, 132, 14);
		frame.getContentPane().add(lblTableSizeDouble);
		
		JLabel lblTableSizeChaining = new JLabel("Table Size : " + fileOperationChaining.chainedHashTable.getSize_of_table());
		lblTableSizeChaining.setBounds(985, 260, 152, 14);
		frame.getContentPane().add(lblTableSizeChaining);
		
		JLabel lblCollisionLinear = new JLabel("Collision : " + fileOperationLinear.oa.getCollisions());
		lblCollisionLinear.setBounds(308, 311, 110, 14);
		frame.getContentPane().add(lblCollisionLinear);
		
		JLabel lblCollisionQuadratic = new JLabel("Collision : " + fileOperationQuadratic.oa.getCollisions());
		lblCollisionQuadratic.setBounds(538, 311, 126, 14);
		frame.getContentPane().add(lblCollisionQuadratic);
		
		JLabel lblCollisionDouble = new JLabel("Collision : " + fileOperationDouble.oa.getCollisions());
		lblCollisionDouble.setBounds(755, 311, 148, 14);
		frame.getContentPane().add(lblCollisionDouble);
		
		JLabel lblCollisionChaining = new JLabel("Collision : " + fileOperationChaining.chainedHashTable.getCollisionNumber());
		lblCollisionChaining.setBounds(985, 311, 152, 14);
		frame.getContentPane().add(lblCollisionChaining);
		
		
		//Grouping table type buttons
		ButtonGroup tableType = new ButtonGroup();
		tableType.add(rdbtnChaining);
		tableType.add(rdbtnDoubleHashing);
		tableType.add(rdbtnOpenaddressinglinearProbing);
		tableType.add(rdbtnQuadraticProbing);
		
		//Grouping sorting type buttons
		ButtonGroup sortingType = new ButtonGroup();
		sortingType.add(rdbtnBubblesort);
		sortingType.add(rdbtnInsertionsort);
		sortingType.add(rdbtnMergesort);
		sortingType.add(rdbtnQuicksort);
		sortingType.add(rdbtnRadixsort);
		sortingType.add(rdbtnSelectionsort);
		
		JButton btnChaininginsertion = new JButton("Chaining-Insertion");
		btnChaininginsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] arr = queryProcess();
				try {
					searchChainingInserion(arr);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnChaininginsertion.setBounds(47, 400, 139, 23);
		frame.getContentPane().add(btnChaininginsertion);
		
		JButton btnNewButton = new JButton("Chaining-Selection");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchChainingSelection(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(201, 400, 148, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chaining-Quick");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchChainingQuick(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(359, 400, 139, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Chaining-Merge");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchChainingMerge(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(508, 400, 125, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Chaining-Radix");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchChainingRadix(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(645, 400, 148, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnChainingbubble = new JButton("Chaining-Bubble");
		btnChainingbubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchChainingBubble(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChainingbubble.setBounds(803, 400, 153, 23);
		frame.getContentPane().add(btnChainingbubble);
		
		JButton btnLinearinsertion = new JButton("Linear-Insertion");	
		btnLinearinsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchLinearInsertion(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLinearinsertion.setBounds(47, 434, 139, 23);
		frame.getContentPane().add(btnLinearinsertion);
		
		JButton btnLinearselection = new JButton("Linear-Selection");
		btnLinearselection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleSelection(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLinearselection.setBounds(201, 434, 148, 23);
		frame.getContentPane().add(btnLinearselection);
		
		JButton btnLinearquick = new JButton("Linear-Quick");
		btnLinearquick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchLinearQuick(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLinearquick.setBounds(359, 434, 139, 23);
		frame.getContentPane().add(btnLinearquick);
		
		JButton btnLinearmerge = new JButton("Linear-Merge");
		btnLinearmerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchLinearMerge(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLinearmerge.setBounds(508, 434, 125, 23);
		frame.getContentPane().add(btnLinearmerge);
		
		JButton btnLinearradix = new JButton("Linear-Radix");
		btnLinearradix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchLinearRadix(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLinearradix.setBounds(643, 434, 148, 23);
		frame.getContentPane().add(btnLinearradix);
		
		JButton btnLinearbubble = new JButton("Linear-Bubble");
		btnLinearbubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchLinearBubble(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLinearbubble.setBounds(803, 434, 153, 23);
		frame.getContentPane().add(btnLinearbubble);
		
		JButton btnQuadraticinsertion = new JButton("Quadratic-Insertion");
		btnQuadraticinsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchQuadraticInsertion(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuadraticinsertion.setBounds(50, 468, 139, 23);
		frame.getContentPane().add(btnQuadraticinsertion);
		
		JButton btnDoubleinsertion = new JButton("Double-Insertion");
		btnDoubleinsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleInsertion(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoubleinsertion.setBounds(50, 502, 139, 23);
		frame.getContentPane().add(btnDoubleinsertion);
		
		JButton btnQuadraticselection = new JButton("Quadratic-Selection");
		btnQuadraticselection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchQuadraticSelection(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuadraticselection.setBounds(201, 468, 148, 23);
		frame.getContentPane().add(btnQuadraticselection);
		
		JButton btnDoubleselection = new JButton("Double-Selection");
		btnDoubleselection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleSelection(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoubleselection.setBounds(201, 502, 148, 23);
		frame.getContentPane().add(btnDoubleselection);
		
		JButton btnQuadraticquick = new JButton("Quadratic-Quick");
		btnQuadraticquick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchQuadraticQuick(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuadraticquick.setBounds(359, 468, 139, 23);
		frame.getContentPane().add(btnQuadraticquick);
		
		JButton btnDoublequick = new JButton("Double-Quick");
		btnDoublequick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleQuick(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoublequick.setBounds(359, 502, 139, 23);
		frame.getContentPane().add(btnDoublequick);
		
		JButton btnQuadraticmerge = new JButton("Quadratic-Merge");
		btnQuadraticmerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchQuadraticMerge(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuadraticmerge.setBounds(508, 468, 125, 23);
		frame.getContentPane().add(btnQuadraticmerge);
		
		JButton btnDoublemerge = new JButton("Double-Merge");
		btnDoublemerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleMerge(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoublemerge.setBounds(508, 502, 125, 23);
		frame.getContentPane().add(btnDoublemerge);
		
		JButton btnQadraricradix = new JButton("Quadratic-Radix");
		btnQadraricradix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchQuadraticRadix(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQadraricradix.setBounds(643, 468, 148, 23);
		frame.getContentPane().add(btnQadraricradix);
		
		JButton btnDoubleradix = new JButton("Double-Radix");
		btnDoubleradix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleRadix(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoubleradix.setBounds(643, 502, 148, 23);
		frame.getContentPane().add(btnDoubleradix);
		
		JButton btnQuadraticbubble = new JButton("Quadratic-Bubble");
		btnQuadraticbubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchQuadraticBubble(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuadraticbubble.setBounds(803, 468, 153, 23);
		frame.getContentPane().add(btnQuadraticbubble);
		
		JButton btnDoublebubble = new JButton("Double-Bubble");
		btnDoublebubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] arr = queryProcess();
				try {
					searchDoubleBubble(arr);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoublebubble.setBounds(803, 502, 153, 23);
		frame.getContentPane().add(btnDoublebubble);
		
		JButton btnDisplayLinearTable = new JButton("Display Table");
		btnDisplayLinearTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fileOperationLinear.oa.displayTable();
			}
		});
		btnDisplayLinearTable.setBounds(284, 352, 117, 23);
		frame.getContentPane().add(btnDisplayLinearTable);
		
		JButton btnDisplayQuadraticTable = new JButton("Display Table");
		btnDisplayQuadraticTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileOperationQuadratic.oa.displayTable();
			}
		});
		btnDisplayQuadraticTable.setBounds(508, 352, 125, 23);
		frame.getContentPane().add(btnDisplayQuadraticTable);
		
		JButton btnDisplayDoubleTable = new JButton("Display Table");
		btnDisplayDoubleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileOperationDouble.oa.displayTable();
			}
		});
		btnDisplayDoubleTable.setBounds(725, 352, 129, 23);
		frame.getContentPane().add(btnDisplayDoubleTable);
		
		JButton btnDisplayChainingTable = new JButton("Display Table");
		btnDisplayChainingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					fileOperationChaining.chainedHashTable.display();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisplayChainingTable.setBounds(952, 352, 126, 23);
		frame.getContentPane().add(btnDisplayChainingTable);
		
		
		
		
		
	}
	
	public String[] queryProcess(){
		String queryText = query.getText().toLowerCase();
		String[] processedQuery = queryText.split(" ");
		return processedQuery;
	}
	
	//Search Methods
	//Linear
	public void searchLinearMerge(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationLinear.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.LINEAR);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.MERGE);
	}
	
	public void searchLinearQuick(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationLinear.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.LINEAR);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.QUICK);
	}
	public void searchLinearBubble(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationLinear.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.LINEAR);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.BUBBLE);
	}
	public void searchLinearSelection(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationLinear.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.LINEAR);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.SELECTION);
	}
	public void searchLinearInsertion(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationLinear.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.LINEAR);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.INSERTION);
	}
	public void searchLinearRadix(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationLinear.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.LINEAR);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.RADIX);
	}
	
	//Quadratic
	public void searchQuadraticMerge(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationQuadratic.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.QUADRATIC);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.MERGE);
	}
	
	public void searchQuadraticQuick(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationQuadratic.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.QUADRATIC);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.QUICK);
	}
	public void searchQuadraticBubble(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationQuadratic.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.QUADRATIC);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.BUBBLE);
	}
	public void searchQuadraticSelection(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationQuadratic.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.QUADRATIC);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.SELECTION);
	}
	public void searchQuadraticInsertion(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationQuadratic.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.QUADRATIC);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.INSERTION);
	}
	public void searchQuadraticRadix(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationQuadratic.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.QUADRATIC);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.RADIX);
	}
	//Double
	public void searchDoubleMerge(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationDouble.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.DOUBLE);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.MERGE);
	}
	
	public void searchDoubleQuick(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationDouble.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.DOUBLE);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.QUICK);
	}
	public void searchDoubleBubble(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationDouble.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.DOUBLE);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.BUBBLE);
	}
	public void searchDoubleSelection(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationDouble.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.DOUBLE);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.SELECTION);
	}
	public void searchDoubleInsertion(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationDouble.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.DOUBLE);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.INSERTION);
	}
	public void searchDoubleRadix(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationDouble.oa.search(givenarr[i].toString().toLowerCase(), fileOperationLinear.oa.probing.DOUBLE);
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.RADIX);
	}
	//Chaining
	public void searchChainingQuick(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationChaining.chainedHashTable.search((givenarr[i].toString().toLowerCase()));
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.QUICK);
	}
	public void searchChainingMerge(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationChaining.chainedHashTable.search((givenarr[i].toString().toLowerCase()));
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.MERGE);
	}
	public void searchChainingInserion(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationChaining.chainedHashTable.search((givenarr[i].toString().toLowerCase()));
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.INSERTION);
	}
	public void searchChainingSelection(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationChaining.chainedHashTable.search((givenarr[i].toString().toLowerCase()));
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.SELECTION);
	}
	public void searchChainingBubble(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationChaining.chainedHashTable.search((givenarr[i].toString().toLowerCase()));
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.BUBBLE);
	}
	public void searchChainingRadix(String[] givenarr) throws FileNotFoundException{
		TextList[] listArr = new TextList[givenarr.length];
		for (int i = 0; i < listArr.length; i++) {
			
			listArr[i]= fileOperationChaining.chainedHashTable.search((givenarr[i].toString().toLowerCase()));
		}
		Ranking rank = new Ranking();
		rank.comparison(listArr,rank.sortType.RADIX);
	}
}
