
require 'memcached'

#pipelined, good for write
$cache = Memcached.new("localhost:11211", :no_block => true, :buffer_requests => true, :noreply => true, :binary_protocol => false)

i = 0
Dir.glob("./img/*.jpg") do |f|
    i = i + 1;
    key = f.match(/([a-zA-Z]+)\.jpg/)[1]
    value = File.read(f)
    $cache.set(i.to_s, key, 0, false)
    $cache.set(key, value, 0, false)
end

puts "Total records: #{i}"
