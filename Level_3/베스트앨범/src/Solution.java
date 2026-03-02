import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class Music {
        int id;
        int play;
        String genre;

        Music(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlaySum = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlaySum.put(genres[i], genrePlaySum.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(i, plays[i], genres[i]));
        }

        List<String> sortedGenres = genrePlaySum.keySet().stream()
                .sorted((a, b) -> genrePlaySum.get(b) - genrePlaySum.get(a)) // 장르의 재생횟수 기준으로 내림차순으로 정렬
                .collect(Collectors.toList()); // List<String>으로 변환
        List<Integer> result = new ArrayList<>();
        for (String g : sortedGenres) {
            List<Music> filtered = musicList.stream()
                    .filter(m -> m.genre.equals(g)) // 조건에 맞지 않는 요소 제거 
                    .sorted((m1, m2) -> { // 음악별 재생횟수 기준으로 내림차순으로 정렬
                        if (m1.play != m2.play) return m2.play - m1.play;
                        return 0;
                    })
                    .limit(2) // 최대 2개
                    .collect(Collectors.toList()); // List<Music>으로 변환
            for (Music m : filtered) {
                result.add(m.id);
            }
        }
        return result.stream().mapToInt(i -> i).toArray(); // 현재 List<Integer> result를 int[]로 바꾸기 위한 변환 작업(언박싱)
    }
}
