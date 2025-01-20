package org.jesperancinha.sftd.flash419.contexes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringFlash419Configuration {

    @Bean
    public SongObject songObject() {
        return SongObject.builder().allSongs(Arrays.asList(
                "Beyonce feat. Shakira - Beautiful Liar (Freemasons Club Vox) 0:00:00",
                "Moby - Disco Lies (Freemasons Club Mix) 0:09:39",
                "Kylie Minogue - The One (Freemasons Club Mix) 0:17:16",
                "London Grammar - Nightcall (Freemasons Remix) 0:24:22",
                "Beyonce - Green Light (Freemasons Club Remix) 0:30:58",
                "Freemasons ft. Bailey Tzuke - Uninvited (Club Mix) 0:37:50",
                "Solange Knowles - Sandcastle Disco (Freemasons Club Mix) 0:45:19",
                "Sophie Ellis-Bextor - Bittersweet (Freemasons Club Mix) 0:52:49",
                "Rihanna - Only Girl In The World (Freemasons Remix) 1:00:26",
                "Freemasons Feat. Sophie Ellis Bextor- Heartbreak (Club Mix) 1:06:32",
                "Beyonce - De Javu (Freemasons Club Mix) 1:14:00"
        )).build();
    }
}
