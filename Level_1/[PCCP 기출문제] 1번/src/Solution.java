class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSeconds = toSeconds(video_len);
        int currentSeconds = toSeconds(pos);
        int opStartSeconds = toSeconds(op_start);
        int opEndSeconds = toSeconds(op_end);

        for (String cmd : commands) {
            if (currentSeconds >= opStartSeconds && currentSeconds <= opEndSeconds) {
                currentSeconds = opEndSeconds;
            }

            if (cmd.equals("next")) {
                currentSeconds += 10;
                if (videoSeconds - currentSeconds < 0) currentSeconds = videoSeconds;
            } else {
                currentSeconds -= 10;
                if (currentSeconds < 0) currentSeconds = 0;
            }

            if (currentSeconds >= opStartSeconds && currentSeconds <= opEndSeconds) {
                currentSeconds = opEndSeconds;
            }
        }

        return String.format("%02d:%02d", currentSeconds / 60, currentSeconds % 60);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

// 초단위로 전부 바꿔 계산하기
// String.Format 문자열 안에 변수의 값을 삽입하여 특정한 형식(Format)을 갖춘 문자열을 만들어내는 메서드