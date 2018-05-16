

#include<stdlib.h>
#include<stdio.h>

#include<MAuthor.h>
#include<MDetails.h>
#include<MFinalOutput.h>

int main()
{
    printf("===== DEBUT TEST =====\n");

    MFinalOutput *mFinalOutput = new_MFinalOutput();

    MAuthor *mAuthor = new_MAuthor();
    //Premier compositeur
    mAuthor->vt->setName("Johann Sebastian Bach");

    MDetails *mDetails = new_MDetails();
    mDetails->setAttribute("BIRTH");
    mDetails->setValue("1685");

    mAuthor->vt->addDetails(mDetails);

    mDetails->setAttribute("DEATH");
    mDetails->setValue("1750");

    mAuthor->vt->addDetails(mDetails);

    mFinalOutput.addAuthors(mAuthor);

    //Deuxième compositeur
    mAuthor->vt->setName("George Frideric Handel");

    mDetails->setAttribute("BIRTH");
    mDetails->setValue("1685");

    mAuthor->vt->addDetails(mDetails);

    mDetails->setAttribute("DEATH");
    mDetails->setValue("1759");

    mAuthor->vt->addDetails(mDetails);

    mFinalOutput.addAuthors(mAuthor);

    // Troisième compositeur
    mAuthor->vt->setName("Wolfgang Amadeus Mozart");

    mDetails->setAttribute("BIRTH");
    mDetails->setValue("1756");

    mAuthor->vt->addDetails(mDetails);

    mDetails->setAttribute("DEATH");
    mDetails->setValue("1791");

    mAuthor->vt->addDetails(mDetails);

    mFinalOutput.addAuthors(mAuthor);

    Char* finalOutput = mFinalOutput.build();

    printf(finalOutput);

    printf("===== FIN TEST =====\n");

    #ifdef __WIN32__
        system("PAUSE");
    #endif
        return 0;
}