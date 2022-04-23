class Codec {
    private array $array = [];
    private $i = 0;
    
    function encode($longUrl) {
        $this->array[] = $longUrl;
        $string = "http://tinyurl.com/".$this->i;
        $this->i= $this->i + 1;
        print_r($string);
        return $string;
    }
    
    /**
     * Decodes a shortened URL to its original URL.
     * @param String $shortUrl
     * @return String
     */
    function decode($shortUrl) {
        $url = "http://tinyurl.com/";
        $index = str_replace($url, '',$shortUrl);
        print_r($index);
        print_r($this->array);
        $longUrl =  $this->array[$index] ;
        print_r($longUrl);
        return $longUrl;
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * $obj = Codec();
 * $s = $obj->encode($longUrl);
 * $ans = $obj->decode($s);
 */