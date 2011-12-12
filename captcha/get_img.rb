
require 'memcached'

$cache = Memcached.new("localhost:11211")

i = 10000
until i == 0 do
    key = $cache.get(i.to_s, false)
    value = $cache.get(key, false)
    puts "#{i}, #{key}, #{value.length}"

    i = i - 1;
end

