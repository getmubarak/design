class StatisticsReport
{
    protected data;

    public function getData(string format)
    {
        switch(format) {
            case 'csv':
                $lines = [];
                foreach ($this->data as $row) {
                    $lines = implode(",", $row);
                }
                return implode("\n", $lines);

            case 'word': 
                ...
                //format as word
                return $word

            case 'html':
                $html = '';
                // format as HTML ...
                return $html;
        }
    }
}
