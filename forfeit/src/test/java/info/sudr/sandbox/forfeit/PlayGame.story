package info.sudr.sandbox.forfeit

scenario "ignores numbers divisible by 7", {
	given "a forfeit game", {
		game = new Game()
	}
	
	when 'we play for 100', {
		result = game.play(100)
		println result
		println 'count: ' + result.size()
	}
	
	then 'numbers divisible by 7 are not present', {
		result.each { n -> 
			n.mod(7).shouldNotEqual 0
		}
	}
	and
	then 'numbers containing 7 are not present', {
		result.each { n ->
			Integer.toString(n).contains('7').shouldNotEqual true
		}
	}
	and
	then 'numbers whose sum of their digits is divisible by 7 are not present', {
		result.each { n ->
			sum = 0
			(n as String[]).each {
				sum += Integer.valueOf(it)
			}
			sum.mod(7).shouldNotEqual 0
		}
	}
}