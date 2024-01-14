package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int lastId = 0;
		List<WiseSaying> wiseSayings = new ArrayList<>();
		System.out.println("==명언앱실행==");

		while (true) {
			System.out.print("명령어 : ");
			String cmd = sc.nextLine();

			if (cmd.equals("종료")) {
				System.out.println("==명언앱종료==");
				break;
			}

			if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언 : ");
				String wise = sc.nextLine();
				System.out.println("작가 : ");
				String author = sc.nextLine();

				wiseSayings.add(new WiseSaying(id, wise, author));

				System.out.println(id + "번 명언이 등록되엇습니다");
				lastId++;
			} else if (cmd.equals("목록")) {
				System.out.println("==목록==");
				if (wiseSayings.size() == 0) {
					System.out.println("등록된 게시글이 없어");
					continue;
				}

				System.out.println("번호  / 명언  /  작가");
				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					System.out.printf(" %d  /  %s  /   %s  \n", wiseSayings.get(i).getId(),
							wiseSayings.get(i).getWise(), wiseSayings.get(i).getAuthor());
				}
			} else if (cmd.startsWith("삭제")) {
				String[] cmdBits = cmd.split("\\?", 2);
				if (cmdBits.length == 1) {
					System.out.println("에러 1 명령어 다시 입력해");
					continue;
				}
				String[] cmdBits2 = cmdBits[1].split("=", 2);
				if (cmdBits2.length == 1) {
					System.out.println("에러 2 명령어를 다시 입력해");
					continue;
				}

				int id = -1;
				try {
					id = Integer.parseInt(cmdBits2[1]);
				} catch (Exception e) {
					System.out.println("에러 3 정수를 입력해");
					continue;
				}

				// 명령어 파싱
				WiseSaying wiseSaying = null;

				for (WiseSaying foundwiseSaying : wiseSayings) {
					if (foundwiseSaying.getId() == id) {
						wiseSaying = foundwiseSaying;
						break;
					}
				}
				
				if(wiseSaying == null) {
					System.out.println("그런 게시물 없어");
				}else {
					wiseSayings.remove(wiseSaying);
					System.out.println("게시물이 삭제되엇습니다");
				}


			} else if (cmd.startsWith("수정")) {
				String[] cmdBits = cmd.split("\\?", 2);
				if (cmdBits.length == 1) {
					System.out.println("에러 1 명령어 다시 입력해");
					continue;
				}
				String[] cmdBits2 = cmdBits[1].split("=", 2);
				if (cmdBits2.length == 1) {
					System.out.println("에러 2 명령어를 다시 입력해");
					continue;
				}

				int id = -1;
				try {
					id = Integer.parseInt(cmdBits2[1]);
				} catch (Exception e) {
					System.out.println("에러 3 정수를 입력해");
					continue;
				}
				
				WiseSaying wiseSaying = null;

				for (WiseSaying foundwiseSaying : wiseSayings) {
					if (foundwiseSaying.getId() == id) {
						wiseSaying = foundwiseSaying;
						break;
					}
				}
				
				if(wiseSaying == null) {
					System.out.println("그런 게시물 없어");
					continue;
				}
				
				System.out.println("기존 명언 : " + wiseSaying.getWise());
				System.out.println("기존 작가 : " + wiseSaying.getAuthor());
				
				System.out.print("새 명언 :");
				String wise = sc.nextLine();
				System.out.print("새 작가 : ");
				String author = sc.nextLine();
				
				wiseSaying.setWise(wise);
				wiseSaying.setAuthor(author);
				
				System.out.println(id + "번 게시물이 수정되었습니다");
				
			

			} else {
				System.out.println("그런명령어는 없어");
				continue;
			}
		}

		sc.close();
	}
}
