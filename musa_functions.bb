;------------------------------------------------------------------------------------------------MUSAT

Function soita_musa()
Select arvonta
            Case 1
		    	If (music_opt) = 0 Then
                      chnBackground=PlayMusic("international_music\karate2.mp3")
                Else
                      chnBackground=PlayMusic("waves_washing.mp3")
	  			EndIf
            Case 2
;	                chnBackground=PlaySound(musa4)
			    If (music_opt) = 0 Then
					  chnBackground=PlayMusic("international_music\karate2.mp3")
           	      Else
	               	  chnBackground=PlayMusic("waves_washing.mp3")
				EndIf
			Case 3
;	                chnBackground=PlaySound(musa5)
		    	If (music_opt) = 0 Then
			    	 chnBackground=PlayMusic("international_music\karate2.mp3")
                Else
                     chnBackground=PlayMusic("waves_washing.mp3")
		  		EndIf
            Case 4
;	                chnBackground=PlaySound(musa6)
		    	If (music_opt) = 0 Then
			    	 chnBackground=PlayMusic("international_music\karate2.mp3")
                Else
                      chnBackground=PlayMusic("waves_washing.mp3")
				EndIf
           	Case 5
;     	          chnBackground=PlaySound(musa7)
			      If (music_opt) = 0 Then
				      chnBackground=PlayMusic("international_music\karate2.mp3")
                  Else
                      chnBackground=PlayMusic("waves_washing.mp3")
	  			  EndIf
			Case 6
		      	If (music_opt) = 0 Then
				      chnBackground=PlayMusic("international_music\karate2.mp3")
                Else
                	  chnBackground=PlayMusic("waves_washing.mp3")
				EndIf
            Default
			      If (music_opt) = 0 Then
				      chnBackground=PlayMusic("international_music\karate2.mp3")
                  Else
                      chnBackground=PlayMusic("waves_washing.mp3")
				  EndIf
             End Select
End Function

Function musan_arvonta()
If (music_opt = 2) Then 
	musa2 = LoadSound("ik+_music\IK+.mp3")
	musan_ajastin = MilliSecs() + 920000
Else

musan_ajastin = MilliSecs() + 522000
Select arvotaan_musa
            Case 1
		    	If (music_opt) = 0 Then
                     musa2 = LoadSound("international_music\internationalkarate.mp3")
                Else
                      musa2 = LoadSound("international_music\waves_washing.mp3")
						musan_ajastin = MilliSecs() + 252000
	  			EndIf
            Case 2
			    If (music_opt) = 0 Then
					  musa2 = LoadSound("international_music\internationalkarate.mp3")					
           	      Else
	               	  musa2 = LoadSound("international_music\fish.mp3")
						musan_ajastin = MilliSecs() + 242000
				EndIf
			Case 3
		    	If (music_opt) = 0 Then
			    	 musa2 = LoadSound("international_music\internationalkarate.mp3")
                Else
                     musa2 = LoadSound("international_music\aurinko.mp3")
						musan_ajastin = MilliSecs() + 158000
		  		EndIf
            Case 4
		    	If (music_opt) = 0 Then
			    	 musa2 = LoadSound("international_music\internationalkarate.mp3")
                Else
                      musa2 = LoadSound("international_music\purple.mp3")
						musan_ajastin = MilliSecs() + 156000
				EndIf
           	Case 5
			      If (music_opt) = 0 Then
				      musa2 = LoadSound("international_music\internationalkarate.mp3")
                  Else
                      musa2 = LoadSound("international_music\sound.mp3")
						musan_ajastin = MilliSecs() + 219000
	  			  EndIf
			Case 6
		      	If (music_opt) = 0 Then
				      musa2 = LoadSound("international_music\internationalkarate.mp3")
                Else
                	  musa2 = LoadSound("international_music\day.mp3")
						musan_ajastin = MilliSecs() + 157000
				EndIf
			Case 7
		      	If (music_opt) = 0 Then
				      musa2 = LoadSound("international_music\internationalkarate.mp3")
                Else
                	  musa2 = LoadSound("international_music\gusu.mp3")
						musan_ajastin = MilliSecs() + 286000
				EndIf
            Default
			      If (music_opt) = 0 Then
				      musa2 = LoadSound("international_music\internationalkarate.mp3")
                  Else
                      musa2 = LoadSound("international_music\waves_washing.mp3")
						musan_ajastin = MilliSecs() + 252000
				  EndIf
             End Select
EndIf
End Function

Function musan_arvonta2()
If (music_opt = 2) Then 
	musa10 = LoadSound("international_music\international_music\internationalkarate.wav")
Else
Select arvonta
            Case 1
		    	If (music_opt) = 0 Then
                      musa10 = LoadSound("international_music\Japanese.wav")
                Else
                      musa10 = LoadSound("international_music\waves_washing.mp3")
	  			EndIf
            Case 2
			    If (music_opt) = 0 Then
					  musa10 = LoadSound("international_music\Japanese.wav")
           	      Else
	               	  musa10 = LoadSound("international_music\fish.mp3")
				EndIf
			Case 3
		    	If (music_opt) = 0 Then
			    	 musa10 = LoadSound("international_music\Japanese.wav")
                Else
                     musa10 = LoadSound("international_music\aurinko.mp3")
		  		EndIf
            Case 4
		    	If (music_opt) = 0 Then
			    	 musa10 = LoadSound("international_music\Japanese.wav")
                Else
                      musa10 = LoadSound("international_music\purple.mp3")
				EndIf
           	Case 5
			      If (music_opt) = 0 Then
				      musa10 = LoadSound("international_music\Japanese.wav")
                  Else
                      musa10 = LoadSound("international_music\sound.mp3")
	  			  EndIf
			Case 6
		      	If (music_opt) = 0 Then
				      musa10 = LoadSound("international_music\Japanese.wav")
                Else
                	  musa10 = LoadSound("international_music\day.mp3")
				EndIf
			Case 7
		      	If (music_opt) = 0 Then
				      musa10 = LoadSound("international_music\Japanese.wav")
                Else
                	  musa10 = LoadSound("international_music\gusu.mp3")
				EndIf

            Default
			      If (music_opt) = 0 Then
				      musa10 = LoadSound("international_music\Japanese.wav")
                  Else
                      musa10 = LoadSound("international_music\waves_washing.mp3")
				  EndIf
             End Select
EndIf
End Function