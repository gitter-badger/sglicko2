/*
 * Copyright (c) 2015, Andreas Flierl
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package sglicko2

sealed trait EitherOnePlayerWinsOrItsADraw

object EitherOnePlayerWinsOrItsADraw {
  implicit val rules: ScoringRules[EitherOnePlayerWinsOrItsADraw] = new ScoringRules[EitherOnePlayerWinsOrItsADraw] {
    val scoresForTwoPlayers: EitherOnePlayerWinsOrItsADraw => (Double, Double) = {
      case Player1Wins => (1d, 0d)
      case Player2Wins => (0d, 1d)
      case Draw        => (0.5d, 0.5d)
    }
  }
}

case object Player1Wins extends EitherOnePlayerWinsOrItsADraw
case object Player2Wins extends EitherOnePlayerWinsOrItsADraw
case object Draw extends EitherOnePlayerWinsOrItsADraw
