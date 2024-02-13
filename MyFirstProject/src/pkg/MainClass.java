package pkg;

public class MainClass {
	
	public static void main(String[] args) {
		
		Team sdi = new Team("SDI");
		
		// 사원 추가
		sdi.addWorker("1", "employee");
		sdi.addWorker("2", "employee");
		sdi.addWorker("3", "employee");
		sdi.addWorker("4", "employee");
		sdi.addWorker("5", "employee");
		sdi.addWorker("6", "employee");
		sdi.addWorker("7", "employee");
		sdi.addWorker("8", "employee");
		sdi.addWorker("9", "employee");
		sdi.addWorker("10", "employee");
		sdi.addWorker("11", "employee");
		sdi.addWorker("12", "employee");
		sdi.addWorker("13", "employee");
		
		// 부서 사원 직급 변경
		sdi.setPos("1", "CEO");
		sdi.setPos("3", "Fired");
		sdi.setPos("10", "Fired");
		
		System.out.println("\n");
		
		// 부서 사원 출력
		sdi.list();
		
		
	}
}

class Team {
	private final int MAX_AMOUNT = 100;
	private int population = 0;	
	public String tName;
	public Worker[] workers = new Worker[MAX_AMOUNT];
	
	// 부서 이름 설정(생성자)
	public Team(String tName) {
		this.tName = tName;
	}
	// 부서 이름 반환
	public String team() {
		return this.tName;
	}
	
	// 사원 추가
	public void addWorker(String wName, String pos) {
		System.out.println("Workers Amount: " + (population + 1));
		if (population > MAX_AMOUNT - 1) {
			System.out.println("Maximum Workers");
		}
		else {
			workers[population++] = new Worker(wName, pos);
		}
	}
	
	// 사원 리스트 '출력'
	/////////////////////////////////
	// 예제 조건은 사원 리스트 출력이 아닌 반환으로 적혀있는데 반환으로 해야 맞나용?
	/////////////////////////////////
	public void list() {
		for (Worker w: workers) {
			if(w == null) {
				break;
			}
			System.out.println(w.getName() + "     " + w.getPos());
		}
	}
	
	// 사원 직급 변경
	public void setPos(String name, String pos) {
		for (Worker w: workers) {
			if(w.getName().equals(name)) {
				w.pos = pos;
				break;
			}
		}
	}
	
	// 사원 클래스
	class Worker {
		private String wName;
		private String pos;
		
		public Worker(String wName, String pos) {
			this.wName = wName;
			this.pos = pos;
		}
		
		public String getName() {
			return this.wName;
		}
		
		public String getPos() {
			return this.pos;
		}
	}
	
}
