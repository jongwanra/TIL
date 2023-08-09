package gc;

import java.lang.ref.WeakReference;

public class Reachability {
	public static void main(String[] args) {
		// 객체 생성
		String originalObject = new String("Hello, World!");

		// WeakReference를 생성하여 객체를 감싸기
		WeakReference<String> weakRef = new WeakReference<>(originalObject);
        
		// 가비지 컬렉션 실행 (객체 수거 유발)
		System.gc();

		for (int i = 0; i < 1_000_000; i++) {
			System.out.println();
		}
		// WeakReference를 통해 객체에 접근
		String retrievedObject = weakRef.get();

		// 객체가 수거되었는지 확인
		if (retrievedObject == null) {
			System.out.println("객체가 수거되었습니다.");
		} else {
			System.out.println("객체가 아직 유지되었습니다.");
		}
	}

}

