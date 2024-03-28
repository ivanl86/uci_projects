package labs.lab10.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import labs.lab10.*;

import org.junit.Before;
import org.junit.Test;


public class Lab10Test {
	
	private final double EPSILON = 1e-3;
	
	List<NetflixTitle> titleList1;
	List<NetflixTitle> titleList2;
	List<NetflixTitle> titleList3;
	List<NetflixTitle> titleList4;
	List<NetflixTitle> titleList5;
	List<NetflixTitle> titleListBLANK;
	
	//This method will be executed before all the other methods.
	@Before
	public void before() {
		String path = "res/"; //<- Assign the path of the .csv files to this variable. Do not include the file name, 
								// it will be added below.
		titleList1 = NetflixTitlesReader.readFile(path + "titles.csv");
		titleList2 = NetflixTitlesReader.readFile(path + "titles2.csv");
		titleList3 = NetflixTitlesReader.readFile(path + "titles3.csv");
		titleList4 = NetflixTitlesReader.readFile(path + "titles4.csv");
		titleList5 = NetflixTitlesReader.readFile(path + "titles5.csv");
		titleListBLANK = NetflixTitlesReader.readFile(path + "titlesBLANK.csv");
	}
	

	@Test
	public void problem1() {
		assertEquals(5850, NetflixTitlesStats.problem1_countTitles(titleList1.stream()));
		assertEquals(368, NetflixTitlesStats.problem1_countTitles(titleList2.stream()));
		assertEquals(68, NetflixTitlesStats.problem1_countTitles(titleList3.stream()));
		assertEquals(0, NetflixTitlesStats.problem1_countTitles(titleListBLANK.stream()));
	}
	
	@Test
	public void problem2() {
		assertEquals(1, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleList1.stream(), 1940, 1950)); // 1
		assertEquals(7, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleList1.stream(), 1940, 1960)); // 7
		assertEquals(216, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleList1.stream(), 1900, 2000)); // 216
		assertEquals(1158, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleList1.stream(), 2021, 2022)); // 1158
		assertEquals(6, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleList2.stream(), 1987, 1987)); // 6
		assertEquals(0, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleList3.stream(), 1987, 1987)); // 0
		assertEquals(0, NetflixTitlesStats.problem2_countTitlesReleasedInYears(titleListBLANK.stream(), 1900, 3000)); // 0
	}
	
	@Test
	public void problem3() {
		Map<String, List<String>> actual = NetflixTitlesStats.problem3_getTitlesGroupedByAgeCertification(titleList4.stream());
		assertEquals(8, actual.size());
		assertEquals(Arrays.asList("Nobody Knows I'm Here", "Pets United", "Aziz Ansari: Right Now"), actual.get(""));
		assertEquals(Arrays.asList("John Mulaney & The Sack Lunch Bunch"), actual.get("PG")); 
		assertEquals(Arrays.asList("Homecoming: A Film by Beyoncé", "NiNoKuni"), actual.get("PG-13"));
		assertEquals(Arrays.asList("Hard Kill", "Seized"), actual.get("R"));
		assertEquals(Arrays.asList("Legend of Exorcism", "The Surgeon's Cut", "Abyss"), actual.get("TV-14"));
		assertEquals(Arrays.asList("BREAK IT ALL: The History of Rock in Latin America", "Shadow", "Women of the Night", "(Un)Well", "The Naked Director"), actual.get("TV-MA"));
		assertEquals(Arrays.asList("My First First Love"), actual.get("TV-PG"));
		assertEquals(Arrays.asList("Beyblade Burst Surge", "Ricky Zoom"), actual.get("TV-Y"));
		assertNull(actual.get("TV-Y7"));
	}
	
	@Test
	public void problem4() {
		assertEquals(109, NetflixTitlesStats.problem4_countProductionCountries(titleList1.stream())); // 109
		assertEquals(35, NetflixTitlesStats.problem4_countProductionCountries(titleList2.stream())); // 35
		assertEquals(26, NetflixTitlesStats.problem4_countProductionCountries(titleList3.stream())); // 26
		assertEquals(11, NetflixTitlesStats.problem4_countProductionCountries(titleList4.stream())); // 11
		assertEquals(0, NetflixTitlesStats.problem4_countProductionCountries(titleListBLANK.stream())); // 0
	}
	
	@Test
	public void problem5() {
		assertEquals("G, NC-17, PG, PG-13, R, TV-14, TV-G, TV-MA, TV-PG, TV-Y, TV-Y7", 
				NetflixTitlesStats.problem5_getAgeCertifications(titleList1.stream()));
		assertEquals("G, NC-17, PG, PG-13, R, TV-14, TV-G, TV-MA, TV-PG, TV-Y, TV-Y7", 
				NetflixTitlesStats.problem5_getAgeCertifications(titleList2.stream()));
		assertEquals("PG, PG-13, R, TV-14, TV-MA", 
				NetflixTitlesStats.problem5_getAgeCertifications(titleList3.stream()));
		assertEquals("PG, PG-13, R, TV-14, TV-MA, TV-PG, TV-Y", 
				NetflixTitlesStats.problem5_getAgeCertifications(titleList4.stream()));
		assertEquals("", NetflixTitlesStats.problem5_getAgeCertifications(titleList5.stream()));
		assertEquals("", NetflixTitlesStats.problem5_getAgeCertifications(titleListBLANK.stream()));
	}
	
	@Test
	public void problem6() {
		Optional<NetflixTitle> result = 
				NetflixTitlesStats.problem6_getMostPopularTitleInGenre(titleList4.stream(), "animation");
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("NiNoKuni", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitleInGenre(titleList4.stream(), "documentation");
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("Homecoming: A Film by Beyoncé", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitleInGenre(titleList5.stream(), "drama");
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("Nobody Knows I'm Here", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitleInGenre(titleList5.stream(), "comedy");
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("Aziz Ansari: Right Now", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitleInGenre(titleList5.stream(), "documentation");
		assertTrue(result.isEmpty());
		
		result = NetflixTitlesStats.problem6_getMostPopularTitleInGenre(titleListBLANK.stream(), "documentation");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void problem7() {
		assertEquals(4.457, NetflixTitlesStats.problem7_getAverageIMDBScore(titleList3.stream()), EPSILON); 
		assertEquals(6.695, NetflixTitlesStats.problem7_getAverageIMDBScore(titleList4.stream()), EPSILON);
		assertEquals(5.9, NetflixTitlesStats.problem7_getAverageIMDBScore(titleList5.stream()), EPSILON);
	}
	
	@Test
	public void problem8() {
		Map<String, Long> expected = new TreeMap<>();
		assertEquals(expected, NetflixTitlesStats.problem8_countTitlesByGenre(titleList5.stream(), "SHOW")); // empty map
		
		expected.put("animation", 1L);
		expected.put("comedy", 2L);
		expected.put("drama", 1L);
		expected.put("music", 1L);
		assertEquals(expected, NetflixTitlesStats.problem8_countTitlesByGenre(titleList5.stream(), "MOVIE"));
		
		expected.clear();
		expected.put("action", 2L);
		expected.put("animation", 3L);
		expected.put("comedy", 2L);
		expected.put("crime", 3L);
		expected.put("documentation", 3L);
		expected.put("drama", 4L);
		expected.put("family", 1L);
		expected.put("fantasy", 2L);
		expected.put("music", 1L);
		expected.put("reality", 1L);
		expected.put("romance", 1L);
		expected.put("scifi", 2L);
		expected.put("thriller", 1L);
		assertEquals(expected, NetflixTitlesStats.problem8_countTitlesByGenre(titleList4.stream(), "SHOW"));
		
		expected.clear();
		expected.put("animation", 1L);
		expected.put("comedy", 5L);
		expected.put("documentation", 3L);
		expected.put("drama", 3L);
		expected.put("family", 1L);
		expected.put("music", 1L);
		expected.put("reality", 3L);
		expected.put("romance", 1L);
		expected.put("sport", 1L);
		assertEquals(expected, NetflixTitlesStats.problem8_countTitlesByGenre(titleList3.stream(), "SHOW"));
	}
	
	@Test
	public void problem9() {
		List<NetflixTitle> actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleList4.stream(), "CN");
		assertEquals(3, actual.size());
		assertEquals("Legend of Exorcism", actual.get(0).getTitle());
		assertEquals("Pets United", actual.get(1).getTitle());
		assertEquals("Ricky Zoom", actual.get(2).getTitle());
		
		actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleList4.stream(), "US");
		assertEquals(6, actual.size());
		assertEquals("(Un)Well", actual.get(0).getTitle());
		assertEquals("Aziz Ansari: Right Now", actual.get(1).getTitle());
		assertEquals("Hard Kill", actual.get(2).getTitle());
		assertEquals("Homecoming: A Film by Beyoncé", actual.get(3).getTitle());
		assertEquals("John Mulaney & The Sack Lunch Bunch", actual.get(4).getTitle());
		assertEquals("Seized", actual.get(5).getTitle());
		
		actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleList4.stream(), "NL");
		assertEquals(1, actual.size());
		assertEquals("Women of the Night", actual.get(0).getTitle());
		
		actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleList4.stream(), "BE");
		assertEquals(1, actual.size());
		assertEquals("Women of the Night", actual.get(0).getTitle());
		
		actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleList4.stream(), "ZA");
		assertEquals(1, actual.size());
		assertEquals("Shadow", actual.get(0).getTitle());
		
		actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleList4.stream(), "IT");
		assertEquals(0, actual.size());
		
		actual = NetflixTitlesStats.problem9_getTitlesProducedInCountry(titleListBLANK.stream(), "US");
		assertEquals(0, actual.size());
	}
	
	@Test
	public void problem10() {
		assertEquals(36.0, NetflixTitlesStats.problem10_getPercentageOfType(titleList1.stream(), "SHOW"), EPSILON); // 36.0
		assertEquals(64.0, NetflixTitlesStats.problem10_getPercentageOfType(titleList1.stream(), "MOVIE"), EPSILON); // 64.0
		assertEquals(26.08695652173913, NetflixTitlesStats.problem10_getPercentageOfType(titleList2.stream(), "SHOW"), EPSILON); // 26.08695652173913
		assertEquals(73.91304347826086, NetflixTitlesStats.problem10_getPercentageOfType(titleList2.stream(), "MOVIE"), EPSILON); // 73.91304347826086
		assertEquals(17.647058823529413, NetflixTitlesStats.problem10_getPercentageOfType(titleList3.stream(), "SHOW"), EPSILON); // 17.647058823529413
		assertEquals(82.35294117647058, NetflixTitlesStats.problem10_getPercentageOfType(titleList3.stream(), "MOVIE"), EPSILON); // 82.35294117647058
		assertEquals(57.89473684210527, NetflixTitlesStats.problem10_getPercentageOfType(titleList4.stream(), "SHOW"), EPSILON); // 57.89473684210527
		assertEquals(42.10526315789473, NetflixTitlesStats.problem10_getPercentageOfType(titleList4.stream(), "MOVIE"), EPSILON); // 42.10526315789473
		assertEquals(0.0, NetflixTitlesStats.problem10_getPercentageOfType(titleList5.stream(), "SHOW"), EPSILON); // 0.0
		assertEquals(100.0, NetflixTitlesStats.problem10_getPercentageOfType(titleList5.stream(), "MOVIE"), EPSILON); // 100.0
		assertEquals(0.0, NetflixTitlesStats.problem10_getPercentageOfType(titleListBLANK.stream(), "SHOW"), EPSILON); // 0.0
		assertEquals(0.0, NetflixTitlesStats.problem10_getPercentageOfType(titleListBLANK.stream(), "MOVIE"), EPSILON); // 0.0
	}

}
