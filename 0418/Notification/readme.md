# ⏲️ 계란 타이머 앱
## 🧩 기능 설명
버튼을 누르면 타이머(예: 10초)가 시작됩니다.

타이머 종료 시 다음 동작이 실행됩니다:

Notification 알림 생성 (NotificationCompat.Builder 사용)

벨소리 재생

사용자에게 **“10초 더 연장할까요?”**라는 AlertDialog 표시

## 📁 주요 구성 요소
UI 레이아웃
TextView: 상태 표시 (done!, "Egg Timer" 등)
Button: 타이머 시작 버튼 (예: "계란 삶기 시작")

## 🔄 앱 흐름 요약
타이머 시작
사용자가 버튼을 누르면 CountDownTimer로 타이머 시작
타이머 종료 시
Notification 알림 생성 (NotificationCompat.Builder)
알림과 함께 벨소리 재생 (RingtoneManager)
AlertDialog 표시 → "10초 더 연장할까요?"

## 📦 알림 구성
NotificationCompat.Builder 사용
알림 내용: "타이머 종료"
알림 클릭 시 앱으로 이동
시스템 기본 알림음 설정

## 🖼️ 실행 예시
타이머 시작 버튼 클릭 → 10초 카운트다운
완료 시:
"done!" 텍스트 표시
알림 전송 + 벨소리 울림
"10초 더 연장할까요?" 다이얼로그 표시

![Image](https://github.com/user-attachments/assets/8769b7d3-008a-42d6-a07d-1b8754b83140)
